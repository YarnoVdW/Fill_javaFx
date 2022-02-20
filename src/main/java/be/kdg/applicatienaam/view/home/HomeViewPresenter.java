package be.kdg.applicatienaam.view.home;

import be.kdg.applicatienaam.view.home.HomeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeViewPresenter {
    private HomeView view;

    public HomeViewPresenter(HomeView view) {
        this.view = view;
        addEventHandlerInfo();
        updateView();
        addEventHandlerToggle();
    }

    private void updateView() {
    }

    private void addEventHandlerInfo() {
        view.getInfoButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("hier komt de tekst over de info");
                alert.setTitle("Info");
                alert.showAndWait();
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
