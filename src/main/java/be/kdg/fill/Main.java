package be.kdg.fill;

import be.kdg.fill.model.bord.Board;
import be.kdg.fill.view.login.LoginPresenter;
import be.kdg.fill.view.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(view);
        Board bord = new Board();
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Fill");
        primaryStage.getIcons().add(new Image("/fill_homeScreen.png"));

        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
