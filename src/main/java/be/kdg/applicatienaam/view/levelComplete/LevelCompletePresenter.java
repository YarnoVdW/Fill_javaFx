package be.kdg.applicatienaam.view.levelComplete;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import be.kdg.applicatienaam.view.level.LevelPresenter;
import be.kdg.applicatienaam.view.level.LevelView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class LevelCompletePresenter {
    private LevelCompleteView view;
    private Bord bord = new Bord();

    public LevelCompletePresenter(LevelCompleteView view) throws FileNotFoundException, URISyntaxException {
        this.view = view;
        addEventHandlerHome();

        addEventHandlerRestart();
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
    private void addEventHandlerRestart(){
        view.getHerstart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LevelView levelView = new LevelView();
                try {
                    LevelPresenter levelPresenter = new LevelPresenter(levelView, bord);
                } catch (FileNotFoundException | URISyntaxException e) {
                    e.printStackTrace();
                }
                view.getScene().setRoot(levelView);
                levelView.getScene().getWindow().sizeToScene();
            }
        });
    }
}
