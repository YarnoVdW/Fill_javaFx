package be.kdg.fill.model.bord;

import be.kdg.fill.model.Move;
import be.kdg.fill.model.Player;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Board {
    private final BoardPiece[][] boardLayout;
    private final int BOARD_WIDTH = 6;
    private final int BOARD_HEIGHT = 6;

    
    private Move lastTurn = new Move(0, 0);
    private int currentLevel = 1;
    private double volume = 0.5;

    public Board() throws Exception {
        this.boardLayout = new BoardPiece[BOARD_WIDTH][BOARD_HEIGHT];
        this.makePattern();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void fillBoard() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                this.boardLayout[i][j] = new BoardPiece();
            }
        }
    }

    public void makePattern() throws Exception {
        this.fillBoard();

        Image image = new Image("/Oranje.png");
        Image beginImage = new Image("/white.png");
        String pattern = "/maakPatroon.txt";
        URL url = getClass().getResource(pattern);
        assert url != null;
        Path path = Paths.get(url.toURI());
        File file = path.toFile();

        this.boardLayout[0][0].setColor(beginImage);
        this.boardLayout[0][0].setUsed(true);

        boolean isEmpty = false;

        try (Scanner scanner = new Scanner(file)) {
            int i = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(++i != this.currentLevel) continue;
                else isEmpty = false;

                String[] coordinateString = line.split("#");
                for (String number : coordinateString) {
                    String[] split = number.split(",");

                    int xCoordinate = Integer.parseInt(split[0].trim()),
                            yCoordinate = Integer.parseInt(split[1].trim());

                    BoardPiece boardPiece = this.boardLayout[xCoordinate][yCoordinate];
                    boardPiece.setColor(image);
                    boardPiece.setUsable(true);
                }
            }
        }

        if(isEmpty) System.out.println("Is empty");
    }

    public boolean isAllowedMove(Move move) {
        BoardPiece boardPiece = this.getBoardPiece(move);
        if(boardPiece == null) return false;
        return boardPiece.isUsable();
    }

    public boolean isNextTo(Move move) {
        int rowDiff = Math.abs(this.lastTurn.getRow() - move.getRow());
        int colDiff = Math.abs(this.lastTurn.getColumn() - move.getColumn());
        return (rowDiff == 1 ^ colDiff == 1) && rowDiff + colDiff == 1;
    }

    public void setLastTurn(Move lastTurn) {
        this.lastTurn = lastTurn;
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

        return Arrays.stream(this.boardLayout)
                .allMatch(boardPieces -> Arrays.stream(boardPieces)
                        .filter(vakje -> vakje.makeColor() != null)
                        .allMatch(BoardPiece::isUsed));
    }

    public BoardPiece[][] getBoardLayout() {
        return boardLayout;
    }

    public void playSound() {
        if (isCompleted()) {
            AudioClip clip = new AudioClip(Objects.requireNonNull(this.getClass().getResource("/complete.mp3")).toExternalForm());
            clip.play(volume);
        }
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }



}
