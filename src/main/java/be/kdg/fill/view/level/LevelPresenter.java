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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class LevelPresenter {
    private final LevelView view;
    private final Board board;
    String pattern;

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
                Move move = new Move(moveY, moveX);

                if(board.isAllowedMove(move) && board.isNextTo(move)) {
                    view.setPosition(board.getBoardLayout()[moveY][moveX].giveColor(), moveX, moveY);
                }
                board.makeMove(move);
                if(board.isCompleted()) {
                    board.playSound();
                    if(this.board.getPattern().equals("/maakPatroon.txt")) {
                        if(this.board.getCurrentLevel() >= Player.getLevelDif1()) {
                            if(!this.board.isGameComplete()){
                                Player.setLevelsPlayedDif1(Player.getPlayerName(),this.board.getCurrentLevel()+1);
                            }
                            //we moeten enkel updaten als het level nog niet gespeeld is
                        }
                    } else if(this.board.getPattern().equals("/patroonDif2.txt")) {
                        if(this.board.getCurrentLevel() >= Player.getLevelDif2()) {
                            if(!this.board.isGameComplete()){
                                Player.setLevelsPlayedDif2(Player.getPlayerName(), this.board.getCurrentLevel()+1);
                            }
                        }
                    }

                    try {
                        levelComplete();
                    } catch (Exception ex) {

                    }


                }
            });


    }
    private void levelComplete() throws Exception {
        if (board.isGameComplete()){
            if(pattern.equals("/maakPatroon.txt")) Player.setLevelsPlayedDif2(Player.getPlayerName(), 1);
            GameCompleteView gameCompleteView = new GameCompleteView();
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
                view.setPosition(board.getBoardLayout()[i][j].makeColor(), i , j);
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
            Board.setVolume(0.5);
        }
    }

}
