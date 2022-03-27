
package be.kdg.fill.view.level;

import be.kdg.fill.model.move.Move;
import be.kdg.fill.model.player.Player;
import be.kdg.fill.model.board.Board;
import be.kdg.fill.model.utilities.FillGameException;
import be.kdg.fill.view.gamecomplete.GameCompletePresenter;
import be.kdg.fill.view.gamecomplete.GameCompleteView;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.levelcomplete.LevelCompletePresenter;
import be.kdg.fill.view.levelcomplete.LevelCompleteView;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URISyntaxException;
/**Deze klasse zorgt voor de juiste werking van het level. Met onder andere de dragger om het patroon te kunnen "draggen"
 */
public class LevelPresenter {
    private final LevelView view;

    public LevelPresenter(LevelView view, Board board, String pattern) throws FillGameException {
        this.view = view;
        addEventHandler(pattern, board);
        board.makePattern(pattern);

        try {
            board.countPatternLines(pattern);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            System.out.println("there seems to be a problem at the level presenter");
        }

        this.fillBoard(board);
        addEventHandlerRestart(board.getCurrentLevel(), pattern);
        addEventHandlerHome();
        addEventHandlerToggle(board);

    }

    private void levelComplete(String pattern, Board board) throws FillGameException {
        if (board.isGameComplete()){

            if(pattern.equals("/makePatternDif1.txt") && Player.getPlayerLevels2().isEmpty()) {
                Player.setLevelsPlayedDif2(Player.getPlayerName(), 1);
            }
            GameCompleteView gameCompleteView = new GameCompleteView();
            if(pattern.equals("/makePatternDif2.txt")) gameCompleteView.getLabel().setText("");

            GameCompletePresenter gameCompletePresenter = new GameCompletePresenter(gameCompleteView);
            view.getScene().setRoot(gameCompleteView);
            gameCompleteView.getScene().getWindow().sizeToScene();
        }else {
            LevelCompleteView levelCompleteView = new LevelCompleteView();
            LevelCompletePresenter presenter = new LevelCompletePresenter(levelCompleteView, board.getCurrentLevel() + 1, board.getPattern());

            view.getScene().setRoot(levelCompleteView);
            levelCompleteView.getScene().getWindow().sizeToScene();
        }

    }
    private void fillBoard(Board board){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                view.setPosition(board.getBoardLayout()[i][j].getColor(), i, j);
            }
        }
    }

    //event-handlers

    /**De event handler die ervoor zorgt dat er over het bord kan gedragged worden en dat het patroon dan ingekleurd wordt*/
    private void addEventHandler(String pattern, Board board) throws ArrayIndexOutOfBoundsException{

        view.addEventHandler(MouseEvent.MOUSE_DRAGGED, e ->{
            view.setCursor(Cursor.CROSSHAIR);
            int moveX = (int) (e.getX()/50);
            int moveY = (int)(e.getY()/50);
            Move move = new Move(moveX, moveY);

            if(board.isAllowedMove(move) && board.isNextTo(move)) view.setPosition(board.getBoardLayout()[moveX][moveY].giveColor(), moveX, moveY);

            board.makeMove(move);

            if(board.isCompleted()) {
                board.playSound();
                board.setPlayerLevel();
                try {
                    levelComplete(pattern, board);
                } catch (Exception ex) {
                    /*lege catch, de mouse dragger zorgt voor een exception wanneer de volgende scene wordt opgeroepen
                     * ik denk dat deze gewoon te sensitive is en iets te vlug zijn exception geeft*/
                }

            }
        });


    }

    private void addEventHandlerRestart(int nextLevel, String pattern){
        view.getRestart().setOnAction(actionEvent -> {
            try {
                updateViewRestart(nextLevel, pattern);
            } catch (FillGameException e) {
                e.printStackTrace();
            }

        });
    }
    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> updateViewHome());
    }
    private void addEventHandlerToggle(Board board){
        view.getSoundButton().setOnAction(actionEvent -> updateViewSound(board));
    }
    //view updaters
    private void updateViewRestart(int nextLevel, String pattern) throws FillGameException {
        LevelView newView = new LevelView();
        Board board = new Board(pattern);
        board.setCurrentLevel(nextLevel);
        LevelPresenter presenter = new LevelPresenter(newView, board, pattern);
        view.getScene().setRoot(newView);
        newView.getScene().getWindow().sizeToScene();
    }

    private void updateViewHome() {
        HomeView homeView = new HomeView();
        HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
        view.getScene().setRoot(homeView);
        homeView.getScene().getWindow().sizeToScene();
    }

    private void updateViewSound(Board board) {
        if (view.getSoundButton().isSelected()) {
            Image image = new Image("/soundOff.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);
            board.setVolume(0);
        } else {
            Image image = new Image("/soundOn.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);
            board.setVolume(0.25);
        }
    }

}
