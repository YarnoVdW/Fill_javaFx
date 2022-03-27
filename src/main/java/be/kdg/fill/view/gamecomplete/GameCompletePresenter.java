
package be.kdg.fill.view.gamecomplete;

import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
/** Presenter voor wanneer een difficulty is uitgespeeld*/

public class GameCompletePresenter {
    private final GameCompleteView view;

    public GameCompletePresenter(GameCompleteView view) {
        this.view = view;
        addEventHandlerHome();

    }

    private void addEventHandlerHome() {
        this.view.getHomeButton().setOnAction(actionEvent -> updateViewHome());
    }
    private void updateViewHome() {
        HomeView homeView = new HomeView();
        HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
        view.getScene().setRoot(homeView);
        homeView.getScene().getWindow().sizeToScene();
    }
}
