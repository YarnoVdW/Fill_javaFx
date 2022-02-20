package be.kdg.applicatienaam.view.levelComplete;

import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LevelCompletePresenter {
    private LevelCompleteView view;

    public LevelCompletePresenter(LevelCompleteView view) {
        this.view = view;
        addEventHandlerHome();


    }

    private void addEventHandlerHome() {

        view.getHomeButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HomeView homeView = new HomeView();
                HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();

            }
        });
    }
}
