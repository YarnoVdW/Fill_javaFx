/**View voor wanneer een speler een level heeft uitgespeeld*/

package be.kdg.fill.view.levelcomplete;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelCompleteView extends BorderPane {
    private Label label;
    private Button homeButton;
    private Button restart;
    private Button nextLevel;
    private HBox hBox;


    public LevelCompleteView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void layoutNodes() {
        int GRID_PANE_HEIGTH = 250;
        int GRID_PANE_WIDTH = 350;
        this.setMinSize(GRID_PANE_HEIGTH, GRID_PANE_WIDTH);



        this.homeButton.setMinSize(30, 30);
        this.restart.setMinSize(30,30);
        this.nextLevel.setMinSize(30,30);
        this.setPrefSize(GRID_PANE_HEIGTH, GRID_PANE_WIDTH);
        this.setCenter(label);
        this.hBox.getChildren().add(homeButton);
        this.hBox.getChildren().add(restart);
        this.hBox.getChildren().add(nextLevel);
        this.hBox.setAlignment(Pos.BOTTOM_CENTER);
        this.setBottom(hBox);
        this.setPadding(new Insets(20));
        this.label.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    private void initialiseNodes() {
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.restart = new Button("", new ImageView("/herstart.png"));
        this.nextLevel = new Button("", new ImageView("/playButton.png"));
        this.label = new Label("Level Completed!");
        this.hBox = new HBox(10);
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public Button getRestart() {
        return restart;
    }

    public Button getNextLevel() {
        return nextLevel;
    }

}
