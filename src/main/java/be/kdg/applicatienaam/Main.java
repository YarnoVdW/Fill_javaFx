package be.kdg.applicatienaam;

import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.level.LevelView;
import be.kdg.applicatienaam.view.levelComplete.LevelCompletePresenter;
import be.kdg.applicatienaam.view.levelComplete.LevelCompleteView;
import be.kdg.applicatienaam.view.levelSelector.LevelSelectorPresenter;
import be.kdg.applicatienaam.view.levelSelector.LevelSelectorView;
import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import be.kdg.applicatienaam.view.registreer.RegistreerView;
import be.kdg.applicatienaam.view.registreer.RegistreetPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //HomeView view = new HomeView();
        //LevelCompleteView view = new LevelCompleteView();
       // LevelCompletePresenter presenter = new LevelCompletePresenter(view);
        //HomeViewPresenter presenter = new HomeViewPresenter(view);
        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(view);
        //LevelView view = new LevelView();
        //RegistreerView view = new RegistreerView();
        //LevelSelectorView view = new LevelSelectorView();
        //LevelSelectorPresenter presenter = new LevelSelectorPresenter(view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Home");
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
