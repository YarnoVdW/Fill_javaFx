package be.kdg.applicatienaam.view.levelSelector;

import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LevelSelectorPresenter {
    private LevelSelectorView view;

    public LevelSelectorPresenter(LevelSelectorView view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerToggle();
    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HomeView homeView = new HomeView();
                HomeViewPresenter presenter = new HomeViewPresenter(homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
            }
        });
    }
    private void addEventHandlerToggle(){
        view.getSoundButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateViewSound();
            }
        });
    }
    private void updateViewSound() {
        if(view.getSoundButton().isSelected()){

            Image image = new Image("/soundOff.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);

        } else {
            Image image = new Image("/soundOnn.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);
        }
    }
}
