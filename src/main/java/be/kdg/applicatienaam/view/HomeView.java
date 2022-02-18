package be.kdg.applicatienaam.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class HomeView extends GridPane {

    private Button playButton;
    private Button infoButton;
    private ToggleButton soundButton;
    private ImageView imageView;




    public HomeView () {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        playButton = new Button("", new ImageView("/playButton.png"));
        infoButton = new Button("", new ImageView("/info.png"));
        soundButton = new ToggleButton("", new ImageView("/soundOnn.png"));
        imageView = new ImageView("/fill_homeScreen.png");
    }
    private void layoutNodes() {
        //this.playButton.setPrefSize(20,20);
        //this.infoButton.setPrefSize(20,20);
        this.soundButton.setPrefSize(30,30);


        this.setGridLinesVisible(false);
        this.setMinWidth(200);
        this.setMinHeight(200);
        this.playButton.setMinSize(30, 30);
        this.infoButton.setMinSize(30,30);
        this.soundButton.setMinSize(30,30);
        this.add(playButton, 1, 1, 1,1);
        this.add(infoButton, 3,1, 2, 1);
        this.add(soundButton, 3, 1, 1 ,1);
        this.add(imageView, 1, 0, 3,1);
        this.setPadding(new Insets(20));

        this.setAlignment(Pos.CENTER);
        GridPane.setHalignment(playButton, HPos.LEFT);
        GridPane.setHalignment(infoButton, HPos.CENTER);
        GridPane.setHalignment(soundButton, HPos.RIGHT);

        //this.setHgap(10);
        this.setVgap(10);
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
