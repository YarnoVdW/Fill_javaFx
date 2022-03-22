package be.kdg.fill.model.timer;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import java.util.TimerTask;

public class Timer {
    //timer klasse om een melding te geven na 5 minuten dat de persoon wat lang aan het spelen is
    java.util.Timer timer = new java.util.Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("The sun is shining! Go play outside.");
                alert.show();
            });

        }
    };
    public void schedule() {
        timer.schedule(task, 300000);
    }

}
