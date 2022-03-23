package be.kdg.fill;


import be.kdg.fill.model.utilities.Timer;
import be.kdg.fill.view.login.LoginPresenter;
import be.kdg.fill.view.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Timer timer = new Timer();
        timer.schedule();
        LoginView view = new LoginView();
        //HighScoreView view = new HighScoreView();
        //HighScorePresenter presenter = new HighScorePresenter(new HighScoreView());
        LoginPresenter presenter = new LoginPresenter(view);
        //GameCompleteView view = new GameCompleteView();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Fill");
        primaryStage.getIcons().add(new Image("/fill_homeScreen.png"));
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
