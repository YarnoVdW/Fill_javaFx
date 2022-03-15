package be.kdg.fill.view.levelcomplete;

import be.kdg.fill.model.bord.Board;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;

public class LevelCompletePresenter {

    private final LevelCompleteView view;
    private Board board = new Board();

    public LevelCompletePresenter(LevelCompleteView view, int nextLevel) throws Exception {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerRestart();
        addNextLevelHandler(nextLevel);

    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {
            HomeView homeView = new HomeView();
            HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();


        });
    }

    private void addEventHandlerRestart(){
        view.getRestart().setOnAction(actionEvent -> {
            LevelView levelView = new LevelView();
            try {
                LevelPresenter levelPresenter = new LevelPresenter(levelView, board);
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelView);
            levelView.getScene().getWindow().sizeToScene();
        });
    }

    private void addNextLevelHandler(int nextLevel){

        view.getNextLevel().setOnAction(actionEvent -> {

            LevelView levelView = new LevelView();

            try {
                board = new Board();
                board.setCurrentLevel(nextLevel);
                LevelPresenter levelPresenter = new LevelPresenter(levelView, board);
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelView);
            levelView.getScene().getWindow().sizeToScene();
        });
    }

}
