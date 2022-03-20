package be.kdg.fill.view.highscore;

import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;

public class HighScorePresenter {
    private final HighScoreView view;

    public HighScorePresenter(HighScoreView view) {
        this.view = view;
        addEventHandlerHome();
    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {
            HomeView homeView = new HomeView();
            HomeViewPresenter presenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();
        });
    }

}
