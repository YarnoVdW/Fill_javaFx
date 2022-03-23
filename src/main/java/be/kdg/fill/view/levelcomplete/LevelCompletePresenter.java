/**De presenter voor de levelComplete view*/

package be.kdg.fill.view.levelcomplete;

import be.kdg.fill.model.bord.Board;
import be.kdg.fill.model.utilities.FillGameException;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;

public class LevelCompletePresenter {

    private final LevelCompleteView view;
    private final Board board;


    public LevelCompletePresenter(LevelCompleteView view, int nextLevel, String pattern) throws FillGameException {
        this.view = view;
        board = new Board(pattern);
        addEventHandlerHome();
        addEventHandlerRestart(nextLevel, pattern);
        addNextLevelHandler(nextLevel, pattern);


    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {

            HomeView homeView = new HomeView();
            HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();


        });
    }

    private void addEventHandlerRestart(int nextLevel, String pattern) {
        view.getRestart().setOnAction(actionEvent -> {
            LevelView levelView = new LevelView();
            try {
                board.setCurrentLevel(nextLevel-1);
                LevelPresenter levelPresenter = new LevelPresenter(levelView, board, pattern);
            } catch (FillGameException e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelView);
            levelView.getScene().getWindow().sizeToScene();
        });
    }

    private void addNextLevelHandler(int nextLevel, String pattern) {
        view.getNextLevel().setOnAction(actionEvent -> {
            LevelView levelView = new LevelView();

            try {
                board.setCurrentLevel(nextLevel);
                board.setPattern(pattern);
                LevelPresenter levelPresenter = new LevelPresenter(levelView, board ,pattern);
            } catch (FillGameException e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelView);
            levelView.getScene().getWindow().sizeToScene();
        });
    }

}
