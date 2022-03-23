/**Home view klasse*/

package be.kdg.fill.view.home;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class HomeView extends GridPane {

    private Button playButton;
    private Button infoButton;
    private ImageView imageView;
    private HBox hbtn;
    private Button logout;
    private Button resetLevel;
    private Button highScores;



    public HomeView () {
        this.initialiseNodes();
        this.layoutNodes();
        this.getStylesheets().add("style.css");
    }
    private void initialiseNodes() {
        playButton = new Button("", new ImageView("/playButton.png"));
        infoButton = new Button("", new ImageView("/info.png"));
        imageView = new ImageView("/fill_homeScreen.png");
        logout = new Button("", new ImageView("/logout.png"));
        highScores = new Button("", new ImageView("/highscore.png"));
        this.hbtn = new HBox(10);
        this.resetLevel = new Button("", new ImageView("/resetbutton.png"));
    }
    private void layoutNodes() {

        this.setGridLinesVisible(false);
        int GRID_PANE_WIDTH = 250;
        this.setMinWidth(GRID_PANE_WIDTH);
        int GRID_PANE_HEIGHT = 250;
        this.setMinHeight(GRID_PANE_HEIGHT);
        this.playButton.setMinSize(30, 30);
        this.infoButton.setMinSize(30,30);
        this.logout.setMaxSize(25,25);

        this.add(imageView, 1, 0, 3,1);

        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);

        GridPane.setVgrow(hbtn, Priority.ALWAYS);
        GridPane.setVgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(imageView, Priority.ALWAYS);
        GridPane.setHalignment(imageView, HPos.CENTER);
        GridPane.setHalignment(playButton, HPos.LEFT);
        GridPane.setHalignment(infoButton, HPos.CENTER);


        this.hbtn.getChildren().add(playButton);
        this.hbtn.getChildren().add(infoButton);
        this.hbtn.setAlignment(Pos.BOTTOM_CENTER);
        this.hbtn.getChildren().add(logout);
        this.hbtn.getChildren().add(resetLevel);
        this.hbtn.getChildren().add(highScores);
        this.add(hbtn, 1, 4);
        this.setVgap(5);

        this.playButton.setId("playButton");
        this.infoButton.setId("infoButton");
        this.logout.setId("logoutButton");

    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getInfoButton() {
        return infoButton;
    }
    public Button getLogout() {
        return logout;
    }

    public Button getResetLevel() {
        return resetLevel;
    }

    public Button getHighScores() {
        return highScores;
    }
}
