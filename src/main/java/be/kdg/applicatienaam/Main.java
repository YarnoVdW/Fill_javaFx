package be.kdg.applicatienaam;

import be.kdg.applicatienaam.model.Spel;
import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import be.kdg.applicatienaam.view.level.LevelPresenter;
import be.kdg.applicatienaam.view.level.LevelView;
import be.kdg.applicatienaam.view.levelChoser.LevelChosePresenter;
import be.kdg.applicatienaam.view.levelChoser.LevelChoseView;
import be.kdg.applicatienaam.view.levelComplete.LevelCompletePresenter;
import be.kdg.applicatienaam.view.levelComplete.LevelCompleteView;
import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //HomeView view = new HomeView();
        //LevelCompleteView view = new LevelCompleteView();
        //LevelCompletePresenter presenter = new LevelCompletePresenter(view);
        //HomeViewPresenter presenter = new HomeViewPresenter(view);
        //LoginView view = new LoginView();
        //LoginPresenter presenter = new LoginPresenter(view);
        Bord bord = new Bord();
        LevelView view = new LevelView();
        LevelPresenter presenter = new LevelPresenter(view, bord);
        //RegistreerView view = new RegistreerView();
        //LevelChoseView view = new LevelChoseView();
        //LevelChosePresenter presenter = new LevelChosePresenter(view);
        //Spel spel = new Spel();
        //spel.startSpel();
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Fill");
        primaryStage.getIcons().add(new Image("/fill_homeScreen.png"));

        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
