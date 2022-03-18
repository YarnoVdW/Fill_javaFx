package be.kdg.fill.view.leveldif;


import be.kdg.fill.model.Player;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.levelchoser.LevelChosePresenter;
import be.kdg.fill.view.levelchoser.LevelChoseView;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.SQLException;


public class LevelDifPresenter {
    private final LevelDifChose view;

    public LevelDifPresenter(LevelDifChose view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerToggle();
        addEventHandlerBtn1();
        addEventHandlerDif2();

    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {
            HomeView homeView = new HomeView();
            HomeViewPresenter presenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();
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
    private void addEventHandlerBtn1(){
        view.getBtn1().setOnAction(actionEvent -> {
            LevelChoseView levelChoseView = null;
            try {
                levelChoseView = new LevelChoseView();
                Player.makeLevelList();
                levelChoseView.getComboBox().setItems(Player.getPlayerLevels());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LevelChosePresenter presenter = new LevelChosePresenter(levelChoseView, "/maakPatroon.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelChoseView);
            levelChoseView.getScene().getWindow().sizeToScene();
        });

    }
    private void addEventHandlerDif2() {
        view.getBtn2().setOnAction(actionEvent -> {
            LevelChoseView levelChoseView = null;
            try {
                levelChoseView = new LevelChoseView();
                Player.makeLevelList();
                levelChoseView.getComboBox().setItems(Player.getPlayerLevels2());

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LevelChosePresenter presenter = new LevelChosePresenter(levelChoseView, "/patroonDif2.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelChoseView);
            levelChoseView.getScene().getWindow().sizeToScene();
        });
    }
}
