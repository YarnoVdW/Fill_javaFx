
package be.kdg.fill.view.levelcomplete;

import be.kdg.fill.model.board.Board;
import be.kdg.fill.model.utilities.FillGameException;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;
/**De presenter voor de levelComplete view*/

public class LevelCompletePresenter {

    private final LevelCompleteView view;
    private final Board board;


    public LevelCompletePresenter(LevelCompleteView view, int nextLevel, String pattern) throws FillGameException {
        this.view = view;
        this.board = new Board(pattern);
        addEventHandlerHome();
        addEventHandlerRestart(nextLevel, pattern);
        addNextLevelHandler(nextLevel, pattern);

    }


    //event-handlers
    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> updateViewHome());
    }

    private void addEventHandlerRestart(int nextLevel, String pattern) {
        view.getRestart().setOnAction(actionEvent -> updateViewRestartLevel(nextLevel, pattern));
    }

    private void addNextLevelHandler(int nextLevel, String pattern) {
        view.getNextLevel().setOnAction(actionEvent -> updateViewNextLevel(nextLevel, pattern));
    }

    //view updaters
    private void updateViewNextLevel(int nextLevel, String pattern) {
        LevelView levelView = new LevelView();
        try {
            board.setCurrentLevel(nextLevel);
            board.setPattern(pattern);
            LevelPresenter levelPresenter = new LevelPresenter(levelView, board ,pattern);
        } catch (FillGameException e) {
            e.printStackTrace();
            System.out.println("There seems to be a problem at the next level handler in the level complete presenter");
        }
        view.getScene().setRoot(levelView);
        levelView.getScene().getWindow().sizeToScene();
    }
    private void updateViewRestartLevel(int nextLevel, String pattern) {
        LevelView levelView = new LevelView();
        try {
            board.setCurrentLevel(nextLevel-1); // -1 omdat hij anders verder gaat ipv dezelfde level opnieuw te spelen
            LevelPresenter levelPresenter = new LevelPresenter(levelView, board, pattern);
        } catch (FillGameException e) {
            e.printStackTrace();
            System.out.println("There seems to be a problem at the restart handler in the level complete presenter");
        }
        view.getScene().setRoot(levelView);
        levelView.getScene().getWindow().sizeToScene();
    }
    private void updateViewHome() {
        HomeView homeView = new HomeView();
        HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
        view.getScene().setRoot(homeView);
        homeView.getScene().getWindow().sizeToScene();
    }

}
