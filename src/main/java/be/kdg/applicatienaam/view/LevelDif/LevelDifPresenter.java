package be.kdg.applicatienaam.view.LevelDif;

import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import be.kdg.applicatienaam.view.levelChoser.LevelChosePresenter;
import be.kdg.applicatienaam.view.levelChoser.LevelChoseView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LevelDifPresenter {
    private LevelDifChose view;

    public LevelDifPresenter(LevelDifChose view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerToggle();
        addEventHandlerBtn1();

    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HomeView homeView = new HomeView();
                HomeViewPresenter presenter = new HomeViewPresenter(homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
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
    private void addEventHandlerBtn1(){
        view.getBtn1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LevelChoseView levelChoseView = new LevelChoseView();
                LevelChosePresenter presenter = new LevelChosePresenter(levelChoseView);
                view.getScene().setRoot(levelChoseView);
                levelChoseView.getScene().getWindow().sizeToScene();
            }
        });
    }
}
