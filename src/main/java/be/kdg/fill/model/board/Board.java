package be.kdg.fill.model.board;

import be.kdg.fill.model.move.Move;
import be.kdg.fill.model.player.Player;
import be.kdg.fill.model.utilities.FillGameException;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
/**De klasse board staat in voor het maken en vullen van het bord
 */

public class Board {

    private final BoardPiece[][] boardLayout;
    private static final int BOARD_WIDTH = 6;
    private static final int BOARD_HEIGHT = 6;
    private String pattern = "/makePatternDif1.txt";
    private boolean gameComplete = false;
    private final ArrayList<Integer> firstMoveX = new ArrayList<>();
    private final ArrayList<Integer> firstMoveY = new ArrayList<>();
    private Move lastTurn;
    private int currentLevel = 1;
    private final Image imageOrange = new Image("/Orange.png");
    private double volume = 1;

    /**De constructor maakt een nieuw boardlayout aan en maakt op dit boardlayout een nieuw patroon*/
    public Board(String pattern) throws FillGameException {
        this.boardLayout = new BoardPiece[BOARD_WIDTH][BOARD_HEIGHT];
        this.makePattern(pattern);
    }

    /**methode om het bord te vullen met allemaal vakjes die mogelijks als patroon gebruikt gaan worden*/
    private void fillBoard() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                this.boardLayout[i][j] = new BoardPiece();
            }
        }
    }
    /**Deze methode leest uit een tekstbestand de coordinaaten van de juiste vakjes die ingekleurd moeten worden en maakt
     * zo een patroon aan om te bespelen*/
    public void makePattern(String pattern) {
        this.fillBoard();
        Image beginImage = new Image("/white.png");
        URL url = getClass().getResource(pattern);
        assert url != null;
        Path path = null;
        try {
            path = Paths.get(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assert path != null;//anders geeft hij een waarschuwing
        File file = path.toFile();


        try (Scanner scanner = new Scanner(file)) {
            int i = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(++i != this.currentLevel) continue;
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
                    boardPiece.setColor(imageOrange);
                    boardPiece.setUsable(true);
                }
                this.boardLayout[firstMoveX.get(0)][firstMoveY.get(0)].setColor(beginImage); //eerste coordinaat gebruiken als startblok
                this.boardLayout[firstMoveX.get(0)][firstMoveY.get(0)].setUsed(true);
                lastTurn = new Move(firstMoveX.get(0), firstMoveY.get(0));
                firstMoveY.clear();
                firstMoveX.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Oops, there is no file found..");
        }

    }

    /**Deze methode telt het aantal lijnen in het patroonbestand voor dif 1. Van zodra het aantal gespeelde levels gelijk is
     * aan het aantal lijnen in het bestand is het spel volledig uitgespeeld.*/
    public void countPatternLines(String filePattern) throws URISyntaxException, IOException {
        URL url = getClass().getResource(filePattern);
        assert url != null;
        Path path;
        long lineCount;
        path = Paths.get(url.toURI());
        lineCount = Files.readAllLines(path).size();
        if(lineCount == this.currentLevel) gameComplete = true;

    }
    /**@return of de move gezet mag worden op een beschikbare plaats*/
    public boolean isAllowedMove(Move move) {
        BoardPiece boardPiece = this.getBoardPiece(move);
        /*wanneer boardpiece nul is betekend dit dat er op dit deel van het bord, geen vakje staat en dus mag dit
        * niet speelbaar zijn*/
        if(boardPiece == null) return false;
        return boardPiece.isUsable();
    }

    /**Deze methode checkt of de volgende move begrensd is met de vorige move.
     * @return boolean true als de move naast de vorige ligt*/
    public boolean isNextTo(Move move) {
        int rowDiff = Math.abs(this.lastTurn.getRow() - move.getRow());
        int colDiff = Math.abs(this.lastTurn.getColumn() - move.getColumn());
        return (rowDiff == 1 ^ colDiff == 1) && rowDiff + colDiff == 1;
        /* Ik gebruik een exclusive or omdat als dit een gewone
        * or is mogen ze ook beide 1 zijn. als dit waar is zouden diagonale zetten ook mogen, wat niet de bedoeling is
        * daarom kijk ik ten eerst of dat 1 van de twee 1 is. en dan tel ik deze op want dit moeten uiteraard opgeteld 1 zijn. Als
        * Ze opgeteld zijn en 1 uitkomen weet je dat er ????n 0 is en de andere 1 (door de xor)*/
    }

    private BoardPiece getBoardPiece(Move move) { //methode om te checken dat alles in de scope van het bord ligt, dus niet buiten het bord
        if (move.getColumn() >= this.boardLayout.length ||
                move.getRow() >= this.boardLayout[move.getColumn()].length) return null;

        return this.boardLayout[move.getColumn()][move.getRow()];
    }

    public void makeMove(Move move) {
        if (this.isAllowedMove(move) && this.isNextTo(move)) {
            this.boardLayout[move.getColumn()][move.getRow()].giveColor();
            this.boardLayout[move.getColumn()][move.getRow()].setUsable(false);
            setLastTurn(move);
        }
    }
     /**Methode om te checken wanneer al de vakjes ingekleurd zijn
      * @return boolean of het level voltooid is*/
    public boolean isCompleted() {
        /* allMatch= ze moeten allemaal true geven, we doen dit twee keer omdat we een 2D array hebben*/
        return Arrays.stream(this.boardLayout)
                .allMatch(boardPieces -> Arrays.stream(boardPieces)
                        .filter(boardPiece -> boardPiece.getColor() != null)
                        .allMatch(BoardPiece::isUsed));
    }


    /**Update de postgresql database*/
    public void setPlayerLevel() {
        if(this.getPattern().equals("/makePatternDif1.txt")) {
            if(this.getCurrentLevel() >= Player.getLevelDif1()) {//we moeten enkel updaten als het level nog niet gespeeld is
                if(!this.isGameComplete()) Player.setLevelsPlayedDif1(Player.getPlayerName(),this.getCurrentLevel()+1);

            }
        } else if(this.getPattern().equals("/makePatternDif2.txt")) {
            if(this.getCurrentLevel() >= Player.getLevelDif2()) {
                if(!this.isGameComplete()) Player.setLevelsPlayedDif2(Player.getPlayerName(), this.getCurrentLevel()+1);


            }
        }

    }
    public void playSound() {
        if(isCompleted()) {
            Media media = new Media(Objects.requireNonNull(this.getClass().getResource("/complete.mp3")).toExternalForm());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.setVolume(volume);
            player.play();
        }
    }

    public boolean isGameComplete() {
        return gameComplete;
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

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
