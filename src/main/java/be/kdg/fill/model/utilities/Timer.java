
package be.kdg.fill.model.utilities;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import java.util.TimerTask;
/**Het spel bevat een timer die ge-scheduled is om na 5minuten een alert te geven dat de speler wat lang aan het spelen is*/

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
