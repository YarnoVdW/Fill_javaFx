package be.kdg.fill.view.levelchoser;

import be.kdg.fill.model.bord.Board;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;

import javafx.scene.media.AudioClip;

import java.util.Objects;

public class LevelChosePresenter {
    private final LevelChoseView view;
    private Board board;



    public LevelChosePresenter(LevelChoseView view) throws Exception {
        this.view = view;

        addEventHandlerComboBox();
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

                board.setCurrentLevel(view.getComboBox().getSelectionModel().getSelectedItem());
                LevelPresenter presenter = new LevelPresenter(levelView, board);

            } catch (Exception e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelView);
            levelView.getScene().getWindow().sizeToScene();
        });

    }
}









