package be.kdg.fill.view.level;

import be.kdg.fill.model.move.Move;
import be.kdg.fill.model.player.Player;
import be.kdg.fill.model.bord.Board;

import be.kdg.fill.view.gamecomplete.GameCompletePresenter;
import be.kdg.fill.view.gamecomplete.GameCompleteView;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.levelcomplete.LevelCompletePresenter;
import be.kdg.fill.view.levelcomplete.LevelCompleteView;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class LevelPresenter {
    private final LevelView view;
    private final Board board;
    private String pattern;

    public LevelPresenter(LevelView view, Board board, String pattern) throws Exception {
        this.view = view;
        addEventHandler();
        this.board = board;
        this.pattern = pattern;
        this.board.makePattern(pattern);
        this.board.countPatternLines(pattern);
        this.fillBoard();
        addEventHandlerRestart(this.board.getCurrentLevel());
        addEventHandlerHome();
        addEventHandlerToggle();



    }
    private void addEventHandler() {
            view.addEventHandler(MouseEvent.MOUSE_DRAGGED, e ->{
                int moveX = (int) (e.getX()/50);
                int moveY = (int)(e.getY()/50);
                Move move = new Move(moveX, moveY);

                if(board.isAllowedMove(move) && board.isNextTo(move)) view.setPosition(board.getBoardLayout()[moveX][moveY].giveColor(), moveX, moveY);

                board.makeMove(move);

                if(board.isCompleted()) {
                    board.playSound();
                    board.setPlayerLevel();
                    try {
                        levelComplete();
                    } catch (Exception ex) {

                    }


                }
            });


    }
    private void levelComplete() throws Exception {
        if (board.isGameComplete()){

            if(pattern.equals("/maakPatroon.txt") && Player.getPlayerLevels2().isEmpty()) {
                Player.setLevelsPlayedDif2(Player.getPlayerName(), 1);
            }
            GameCompleteView gameCompleteView = new GameCompleteView();
            if(pattern.equals("/patroonDif2.txt")) gameCompleteView.setUnlockedLabel(new Label(""));

            GameCompletePresenter gameCompletePresenter = new GameCompletePresenter(gameCompleteView);
            view.getScene().setRoot(gameCompleteView);
            gameCompleteView.getScene().getWindow().sizeToScene();
        }else {
            LevelCompleteView levelCompleteView = new LevelCompleteView();
            LevelCompletePresenter presenter = new LevelCompletePresenter(levelCompleteView, this.board.getCurrentLevel() + 1, board.getPattern());
            view.getScene().setRoot(levelCompleteView);
            levelCompleteView.getScene().getWindow().sizeToScene();
        }

    }
    private void fillBoard(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                view.setPosition(board.getBoardLayout()[i][j].getColor(), i, j);
            }
        }
    }

    private void addEventHandlerRestart(int nextLevel){
        view.getRestart().setOnAction(actionEvent -> {
            try {
                restart(nextLevel);
                board.setPattern(pattern);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
    private void restart(int nextLevel) throws Exception {
        LevelView newView = new LevelView();
        Board board = new Board(pattern);

        board.setCurrentLevel(nextLevel);
        LevelPresenter presenter = new LevelPresenter(newView, board, pattern);
        view.getScene().setRoot(newView);
        newView.getScene().getWindow().sizeToScene();
    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {
            HomeView homeView = new HomeView();
            HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();

        });
    }
    private void addEventHandlerToggle(){
        view.getSoundButton().setOnAction(actionEvent -> updateViewSound());
    }
    private void updateViewSound() {
        if (view.getSoundButton().isSelected()) {

            Image image = new Image("/soundOff.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);
            Board.setVolume(0);

        } else {
            Image image = new Image("/soundOn.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);
            Board.setVolume(0.25);
        }
    }

}
