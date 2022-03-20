package be.kdg.fill.model.bord;

import be.kdg.fill.model.move.Move;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Board {

    private final BoardPiece[][] boardLayout;
    private static final int BOARD_WIDTH = 6;
    private static final int BOARD_HEIGHT = 6;
    private String pattern = "/maakPatroon.txt";
    private boolean gameComplete = false;
    private ArrayList<Integer> firstMoveX = new ArrayList<>();
    private ArrayList<Integer> firstMoveY = new ArrayList<>();
    private Move lastTurn;
    private int currentLevel = 1;
    private static double volume = 0.5;

    public Board(String pattern) throws Exception {
        this.boardLayout = new BoardPiece[BOARD_WIDTH][BOARD_HEIGHT];
        this.makePattern(pattern);
    }

    public void fillBoard() { //methode om het bord te vullen met allemaal vakjes die mogelijks als patroon gebruikt gaan worden
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                this.boardLayout[i][j] = new BoardPiece();
            }
        }
    }

    public void makePattern(String pattern) throws Exception {
        this.fillBoard();
        Image image = new Image("/Oranje.png");
        Image beginImage = new Image("/white.png");
        URL url = getClass().getResource(pattern);
        assert url != null;
        Path path = Paths.get(url.toURI());
        File file = path.toFile();
        boolean isEmpty;



        try (Scanner scanner = new Scanner(file)) {
            int i = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(++i != this.currentLevel) continue;
                else isEmpty = false;
               /*in het bestand staan de patronen geschreven als 1,2#. dit is dus x,y
               * We gaan hier alle lijne splitten met de # zodat we enkel de coordinaten over houden, die gaan we vervolgens ook nog eens
               * opdelen in een x en y coordinaat*/
                String[] coordinateString = line.split("#");
                for (String number : coordinateString) {
                    String[] split = number.split(",");
                    int xCoordinate = Integer.parseInt(split[0].trim()),
                            yCoordinate = Integer.parseInt(split[1].trim());
                    firstMoveX.add(xCoordinate);
                    firstMoveY.add(yCoordinate);

                    /* de x en y coordinaat vullen we hier in in het boardlayout zodat het model weet dat deze vakjes allemaal deel zijn
                    * van het patroon*/
                    BoardPiece boardPiece = this.boardLayout[xCoordinate][yCoordinate];
                    boardPiece.setColor(image);
                    boardPiece.setUsable(true);

                }
                this.boardLayout[firstMoveX.get(0)][firstMoveY.get(0)].setColor(beginImage);
                this.boardLayout[firstMoveX.get(0)][firstMoveY.get(0)].setUsed(true);
                lastTurn = new Move(firstMoveY.get(0), firstMoveX.get(0));
                firstMoveY.clear();
                firstMoveX.clear();
            }
        }

    }

    public void countPatternLines(String filePattern) throws Exception {

        /*In deze methode tel ik het aantal lijnen in het patroon bestand voor dif 1. Van zodra het aantal gespeelde levels gelijk is
        * aan het aantal lijnen in het bestand is het spel volledig uitgespeeld.*/
        URL url = getClass().getResource(filePattern);
        assert url != null;
        Path path = Paths.get(url.toURI());
        long lineCount = Files.readAllLines(path).size();


        if(lineCount == this.currentLevel) {
            gameComplete = true;
        }
    }

    public boolean isAllowedMove(Move move) {
        BoardPiece boardPiece = this.getBoardPiece(move);
        /*wanneer boardpiece nul is betekend dit dat er op dit deel van het bord, geen vakje staat en dus mag dit
        * niet speelbaar zijn*/
        if(boardPiece == null) return false;
        return boardPiece.isUsable();
    }

    public boolean isNextTo(Move move) {


        int rowDiff = Math.abs(this.lastTurn.getRow() - move.getRow());
        int colDiff = Math.abs(this.lastTurn.getColumn() - move.getColumn());
        return (rowDiff == 1 ^ colDiff == 1) && rowDiff + colDiff == 1;
        /*Deze methode checkt of de volgende move begrensd is met de vorige move. Ik gebruik een exclusive or omdat als dit een gewone
        * or is mogen ze ook beide 1 zijn. als dit waar is zouden diagonale zetten ook mogen, wat niet de bedoeling is
        * daarom kijk ik ten eerst of dat 1 van de twee 1 is. en dan tel ik deze op want dit moeten uiteraard opgeteld 1 zijn. Als
        * Ze opgeteld zijn en 1 uitkomen weet je dat er één 0 is en de andere 1 (door de xor)*/
    }

    private BoardPiece getBoardPiece(Move move) {

        if (move.getColumn() >= this.boardLayout.length ||
                move.getRow() >= this.boardLayout[move.getColumn()].length) return null;

        return this.boardLayout[move.getColumn()][move.getRow()];
    }

    public void makeMove(Move move) {
        if (this.isAllowedMove(move) && this.isNextTo(move)) {

            this.boardLayout[move.getColumn()][move.getRow()].giveColor();
            this.boardLayout[move.getColumn()][move.getRow()].setUsable(false);
            setLastTurn(move);
            return;
        }
        if (this.isAllowedMove(move)) {
            this.isNextTo(move);
        }
    }

    public boolean isCompleted() {
        /*Methode om te checken wanneer al de vakjes ingekleurd zijn*/
        return Arrays.stream(this.boardLayout)
                .allMatch(boardPieces -> Arrays.stream(boardPieces)
                        .filter(vakje -> vakje.makeColor() != null)
                        .allMatch(BoardPiece::isUsed));
    }

    public void playSound() {
        if (isCompleted()) {
            AudioClip clip = new AudioClip(Objects.requireNonNull(this.getClass().getResource("/complete.mp3")).toExternalForm());
            clip.play(volume);
        }
    }

    public boolean isGameComplete() {
        return gameComplete;
    }
    public static void setVolume(double volume) {
        Board.volume = volume;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    public String getPattern() {
        return pattern;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
    public void setLastTurn(Move lastTurn) {
        this.lastTurn = lastTurn;
    }
    public BoardPiece[][] getBoardLayout() {
        return boardLayout;
    }
}
