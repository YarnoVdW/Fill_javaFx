package be.kdg.fill.view.gamecomplete;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameCompleteView extends BorderPane {
    private Label label;

    private Button homeButton;
    private HBox hBoxHome;
    public Label unlockedLabel;



    public GameCompleteView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void layoutNodes() {
        int GRID_PANE_HEIGHT = 250;
        int GRID_PANE_WIDTH = 350;
        this.setMinSize(GRID_PANE_HEIGHT, GRID_PANE_WIDTH);



        this.homeButton.setMinSize(30, 30);

        this.setPrefSize(GRID_PANE_HEIGHT, GRID_PANE_WIDTH);
        this.setCenter(label);
        this.setTop(unlockedLabel);
        this.hBoxHome.getChildren().add(homeButton);

        this.hBoxHome.setAlignment(Pos.BOTTOM_CENTER);
        this.setBottom(hBoxHome);
        this.setPadding(new Insets(20));
        this.label.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.unlockedLabel.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));

        this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    private void initialiseNodes() {
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.label = new Label("Game Completed!");
        this.unlockedLabel = new Label("You've unlocked\ndifficulty two!");

        this.hBoxHome = new HBox(10);
    }

    public Button getHomeButton() {
        return homeButton;
    }


    public void setUnlockedLabel(Label unlockedLabel) {
        this.unlockedLabel = unlockedLabel;
    }
}
