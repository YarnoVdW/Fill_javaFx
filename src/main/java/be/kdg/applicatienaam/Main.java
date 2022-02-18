package be.kdg.applicatienaam;

import be.kdg.applicatienaam.model.ApplicatieNaamModel;
import be.kdg.applicatienaam.view.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //HomeView view = new HomeView();
        LevelCompleteView view = new LevelCompleteView();
        //HomeViewPresenter presenter = new HomeViewPresenter(view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Home");
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
