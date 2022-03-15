package be.kdg.fill.view.home;

import be.kdg.fill.model.Player;
import be.kdg.fill.view.leveldif.LevelDifPresenter;
import be.kdg.fill.view.leveldif.LevelDifChose;
import be.kdg.fill.view.login.LoginPresenter;
import be.kdg.fill.view.login.LoginView;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeViewPresenter {
    private final HomeView view;
    private Player player;


    public HomeViewPresenter(HomeView view) {
        this.view = view;
        addEventHandlerInfo();
        updateView();
        addEventHandlerToggle();
        addEventHandlerPlay();
        addEventHandlerLogout();
    }

    private void addEventHandlerPlay() {
        view.getPlayButton().setOnAction(actionEvent -> {
            LevelDifChose levelDifChose = new LevelDifChose();
            LevelDifPresenter presenter = new LevelDifPresenter(levelDifChose);
            view.getScene().setRoot(levelDifChose);
            levelDifChose.getScene().getWindow().sizeToScene();
        });
    }

    private void updateView() {
    }

    private void addEventHandlerInfo() {
        view.getInfoButton().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("hier komt de tekst over de info");
            alert.setTitle("How to play");
            alert.showAndWait();
        });
    }
    private void addEventHandlerToggle(){
        view.getSoundButton().setOnAction(actionEvent -> updateViewSound());
    }
    private void updateViewSound() {
        if(view.getSoundButton().isSelected()){

            Image image = new Image("/soundOff.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);


        } else {
            Image image = new Image("/soundOn.png");
            Node node = new ImageView(image);
            view.getSoundButton().setGraphic(node);
        }
    }
    private void addEventHandlerLogout(){
        view.getLogout().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Are you sure?");
            alert.getButtonTypes().clear();
            ButtonType no = new ButtonType("No");
            ButtonType yes = new ButtonType("Yes");
            alert.getButtonTypes().addAll(no, yes);
            alert.showAndWait();

            if (alert.getResult().equals(yes)) {
                LoginView loginView = new LoginView();
                LoginPresenter presenter = new LoginPresenter(loginView);
                view.getScene().setRoot(loginView);
                loginView.getScene().getWindow().sizeToScene();
            }
        });
    }

}
