package be.kdg.applicatienaam.view.home;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HomeView extends GridPane {

    private Button playButton;
    private Button infoButton;
    private ToggleButton soundButton;
    private ImageView imageView;
    private Background background;
    private BackgroundImage backgroundImage;
    private Image backImage;
    private HBox hbtn;




    public HomeView () {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        playButton = new Button("", new ImageView("/playButton.png"));
        infoButton = new Button("", new ImageView("/info.png"));
        soundButton = new ToggleButton("", new ImageView("/soundOnn.png"));
        imageView = new ImageView("/fill_homeScreen.png");
        this.hbtn = new HBox(10);
    }
    private void layoutNodes() {



        this.setGridLinesVisible(false);
        this.setMinWidth(200);
        this.setMinHeight(200);
        this.playButton.setMinSize(30, 30);
        this.infoButton.setMinSize(30,30);
        this.soundButton.setMinSize(30,30);
        this.add(imageView, 1, 0, 3,1);
        this.setPadding(new Insets(20));

        this.setAlignment(Pos.CENTER);
        GridPane.setHalignment(playButton, HPos.LEFT);
        GridPane.setHalignment(infoButton, HPos.CENTER);
        GridPane.setHalignment(soundButton, HPos.RIGHT);

        this.hbtn.getChildren().add(playButton);
        this.hbtn.getChildren().add(infoButton);
        this.hbtn.getChildren().add(soundButton);
        this.hbtn.setAlignment(Pos.BOTTOM_CENTER);
        this.add(hbtn, 1, 4);
        this.setVgap(5);


    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getInfoButton() {
        return infoButton;
    }

    public ToggleButton getSoundButton() {
        return soundButton;
    }
}