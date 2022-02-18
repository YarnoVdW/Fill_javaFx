package be.kdg.applicatienaam.view;

import be.kdg.applicatienaam.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LevelCompletePresenter {
    private LevelCompleteView view;

    public LevelCompletePresenter(LevelCompleteView view) {
        this.view = view;
        addEventHandlerHome();


    }

    private void addEventHandlerHome() {

        view.getHomeButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
    }
}
