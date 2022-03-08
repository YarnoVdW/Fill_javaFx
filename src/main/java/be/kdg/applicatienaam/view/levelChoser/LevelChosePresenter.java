package be.kdg.applicatienaam.view.levelChoser;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.level.LevelPresenter;
import be.kdg.applicatienaam.view.level.LevelView;
import be.kdg.applicatienaam.view.levelComplete.LevelCompletePresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class LevelChosePresenter {
    private LevelChoseView view;

    public LevelChosePresenter(LevelChoseView view){
        this.view = view;
        addEventHandlerBtn1();
    }

    private void addEventHandlerBtn1() {
        view.getBtn1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playSound();
                LevelView levelView = new LevelView();
                Bord bord = null;
                try {
                    bord = new Bord();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                try {
                    LevelPresenter presenter = new LevelPresenter(levelView, bord);
                } catch (FileNotFoundException | URISyntaxException e) {
                    e.printStackTrace();
                }
                view.getScene().setRoot(levelView);
                levelView.getScene().getWindow().sizeToScene();


            }
        });
    }
    private void playSound(){
        AudioClip clip = new AudioClip(this.getClass().getResource("/klik.mp3").toExternalForm());
        clip.play();
    }
}
