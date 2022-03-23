/** Presenter voor wanneer een difficulty is uitgespeeld*/

package be.kdg.fill.view.gamecomplete;

import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;

public class GameCompletePresenter {
    private GameCompleteView view = new GameCompleteView();

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
