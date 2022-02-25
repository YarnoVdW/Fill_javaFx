package be.kdg.applicatienaam.view.home;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.LevelDif.LevelDifPresenter;
import be.kdg.applicatienaam.view.LevelDif.LevelDifChose;
import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;

public class HomeViewPresenter {
    private HomeView view;
    private Bord bord;


    public HomeViewPresenter(HomeView view) {
        this.view = view;
        addEventHandlerInfo();
        updateView();
        addEventHandlerToggle();
        addEventHandlerPlay();
        addEventHandlerLogout();
    }

    private void addEventHandlerPlay() {
        view.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LevelDifChose levelDifChose = new LevelDifChose();
                LevelDifPresenter presenter = new LevelDifPresenter(levelDifChose);
                view.getScene().setRoot(levelDifChose);
                levelDifChose.getScene().getWindow().sizeToScene();
            }
        });
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
    private void addEventHandlerLogout(){
        view.getLogout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Ben je zeker?");
                alert.getButtonTypes().clear();
                ButtonType neen = new ButtonType("Neen");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(neen, ja);
                alert.showAndWait();
                if (alert.getResult().equals(ja)) {
                    LoginView loginView = new LoginView();
                    LoginPresenter presenter = new LoginPresenter(loginView);
                    view.getScene().setRoot(loginView);
                    loginView.getScene().getWindow().sizeToScene();
                }

            }
        });
    }

}
