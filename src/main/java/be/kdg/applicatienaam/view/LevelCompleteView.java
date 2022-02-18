package be.kdg.applicatienaam.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LevelCompleteView extends GridPane {
    private Label label;
    private Button homeButton;
    private Button herstart;
    private Button volgendLevel;


    public LevelCompleteView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void layoutNodes() {
        this.setGridLinesVisible(true);
        this.setMinWidth(450);
        this.setMinHeight(450);

        this.homeButton.setMinSize(30, 30);
        this.herstart.setMinSize(30,30);
        this.volgendLevel.setMinSize(30,30);
        this.label.setPrefSize(200,200);

        this.add(homeButton, 1, 1, 1,1);
        this.add(herstart, 3,1, 2, 1);
        this.add(volgendLevel, 3, 1, 1 ,1);
        this.add(label, 1, 0, 3,1);

        this.setPadding(new Insets(20));

        GridPane.setHalignment(homeButton, HPos.LEFT);
        GridPane.setHalignment(herstart, HPos.CENTER);
        GridPane.setHalignment(volgendLevel, HPos.RIGHT);
        GridPane.setHalignment(label, HPos.CENTER);

    }

    private void initialiseNodes() {
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.herstart = new Button("", new ImageView("/herstart.png"));
        this.volgendLevel = new Button("", new ImageView("/playButton.png"));
        this.label = new Label("Level Completed");
    }

    public Button getHomeButton() {
        return homeButton;
    }
}
