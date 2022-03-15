package be.kdg.fill;

import be.kdg.fill.model.bord.Board;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;
import be.kdg.fill.view.levelchoser.LevelChosePresenter;
import be.kdg.fill.view.levelchoser.LevelChoseView;
import be.kdg.fill.view.login.LoginPresenter;
import be.kdg.fill.view.login.LoginView;
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
        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(view);
        Board bord = new Board();
        //LevelView view = new LevelView();
        //LevelPresenter presenter = new LevelPresenter(view, bord);
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
