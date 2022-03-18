package be.kdg.fill.view.levelchoser;

import be.kdg.fill.model.Player;
import be.kdg.fill.model.bord.Board;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;

import javafx.scene.control.ComboBox;
import javafx.scene.media.AudioClip;

import java.util.Objects;

public class LevelChosePresenter {
    private final LevelChoseView view;
    private Board board;
    private final String dif;


    public LevelChosePresenter(LevelChoseView view, String dif) throws Exception {
        this.view = view;
        this.dif = dif;
        addEventHandlerComboBox();
        addEventHandlerHome();


    }


    private void playSound() {
        AudioClip clip = new AudioClip(Objects.requireNonNull(this.getClass().getResource("/klik.mp3")).toExternalForm());
        clip.play();
    }

    private void addEventHandlerComboBox() throws Exception {
        board = new Board();
        view.getComboBox().setOnAction(actionEvent -> {
            playSound();
            LevelView levelView = new LevelView();
            try {
                board = new Board();
                board.setPattern(dif);
                board.setCurrentLevel(view.getComboBox().getSelectionModel().getSelectedItem());
                LevelPresenter presenter = new LevelPresenter(levelView, board);

            } catch (Exception e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelView);
            levelView.getScene().getWindow().sizeToScene();
        });

    }
    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {
            HomeView homeView = new HomeView();
            HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();


        });
    }
}









