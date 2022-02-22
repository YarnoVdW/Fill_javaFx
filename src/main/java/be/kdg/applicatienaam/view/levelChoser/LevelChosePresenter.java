package be.kdg.applicatienaam.view.levelChoser;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.level.LevelPresenter;
import be.kdg.applicatienaam.view.level.LevelView;
import be.kdg.applicatienaam.view.levelComplete.LevelCompletePresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
                LevelView levelView = new LevelView();
                Bord bord = new Bord();
                LevelPresenter presenter = new LevelPresenter(levelView, bord);
                view.getScene().setRoot(levelView);
                levelView.getScene().getWindow().sizeToScene();


            }
        });
    }
}
