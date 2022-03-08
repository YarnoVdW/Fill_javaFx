package be.kdg.applicatienaam.view.levelComplete;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelCompleteView extends BorderPane {
    private Label label;
    private Button homeButton;
    private Button herstart;
    private Button volgendLevel;
    private HBox hbtn;
    private final int GRID_PANE_HEIGTH = 250;
    private final int GRID_PANE_WIDTH = 350;


    public LevelCompleteView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void layoutNodes() {
        this.setMinSize(GRID_PANE_HEIGTH, GRID_PANE_WIDTH);



        this.homeButton.setMinSize(30, 30);
        this.herstart.setMinSize(30,30);
        this.volgendLevel.setMinSize(30,30);
        this.setPrefSize(GRID_PANE_HEIGTH, GRID_PANE_WIDTH);
        this.setCenter(label);
        this.hbtn.getChildren().add(homeButton);
        this.hbtn.getChildren().add(herstart);
        this.hbtn.getChildren().add(volgendLevel);
        this.hbtn.setAlignment(Pos.BOTTOM_CENTER);
        this.setBottom(hbtn);
        this.setPadding(new Insets(20));
        this.label.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    private void initialiseNodes() {
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.herstart = new Button("", new ImageView("/herstart.png"));
        this.volgendLevel = new Button("", new ImageView("/playButton.png"));
        this.label = new Label("Level Completed!");
        this.hbtn = new HBox(10);
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public Button getHerstart() {
        return herstart;
    }

    public Button getVolgendLevel() {
        return volgendLevel;
    }

}
