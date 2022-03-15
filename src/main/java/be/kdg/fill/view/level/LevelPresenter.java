package be.kdg.fill.view.level;

import be.kdg.fill.model.Move;
import be.kdg.fill.model.Player;
import be.kdg.fill.model.bord.Board;

import be.kdg.fill.view.levelcomplete.LevelCompletePresenter;
import be.kdg.fill.view.levelcomplete.LevelCompleteView;
import javafx.scene.input.MouseEvent;


public class LevelPresenter {
    private final LevelView view;
    private final Board board;

    public LevelPresenter(LevelView view, Board board) throws Exception {
        this.view = view;
        addEventHandler();
        this.board = board;
        this.board.makePattern();
        this.fillBoard();
        addEventHandlerRestart(this.board.getCurrentLevel());

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
                    if(this.board.getCurrentLevel() >= Player.getLevelsPlayed()) {
                        Player.setLevelsPlayed(Player.getPlayerName(),this.board.getCurrentLevel()+1);
                    }

                    try {
                        levelComplete();

                    } catch (Exception ex) {


                    }
                }
            });


    }
    private void levelComplete() throws Exception {
            LevelCompleteView levelCompleteView = new LevelCompleteView();
            LevelCompletePresenter presenter = new LevelCompletePresenter(levelCompleteView, this.board.getCurrentLevel() + 1);
            view.getScene().setRoot(levelCompleteView);
            levelCompleteView.getScene().getWindow().sizeToScene();
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
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
    private void restart(int nextLevel) throws Exception {
        LevelView newView = new LevelView();
        Board board = new Board();

        board.setCurrentLevel(nextLevel);
        LevelPresenter presenter = new LevelPresenter(newView, board);
        view.getScene().setRoot(newView);
        newView.getScene().getWindow().sizeToScene();
    }

}
