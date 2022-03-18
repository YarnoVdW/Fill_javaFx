package be.kdg.fill.view.gamecomplete;

import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;

public class GameCompletePresenter {
    private final GameCompleteView view;
    public GameCompletePresenter(GameCompleteView view) {
        addEventHandlerHome();
        this.view= view;
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
