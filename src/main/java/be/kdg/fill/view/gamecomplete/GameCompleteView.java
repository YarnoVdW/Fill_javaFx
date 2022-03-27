
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
import javafx.scene.text.TextAlignment;
/**View die bij de gamecompletepresenter hoort*/

public class GameCompleteView extends BorderPane {
    private Label label;
    private Button homeButton;
    private HBox hBoxHome;
    private Label unlockedLabel;


    public GameCompleteView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void layoutNodes() {
        int GRID_PANE_HEIGHT = 250;
        int GRID_PANE_WIDTH = 350;
        this.setMinSize(GRID_PANE_HEIGHT, GRID_PANE_WIDTH);
        this.setPrefSize(GRID_PANE_HEIGHT, GRID_PANE_WIDTH);
        this.setCenter(unlockedLabel);
        BorderPane.setAlignment(label, Pos.TOP_CENTER);
        this.unlockedLabel.setAlignment(Pos.CENTER);
        this.unlockedLabel.setTextAlignment(TextAlignment.CENTER);
        this.unlockedLabel.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.label.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.homeButton.setMinSize(30, 30);
        this.hBoxHome.getChildren().add(homeButton);
        this.hBoxHome.setAlignment(Pos.BOTTOM_CENTER);
        this.setTop(label);
        this.setBottom(hBoxHome);
        this.setPadding(new Insets(20));
        this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    private void initialiseNodes() {
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.label = new Label("Game Completed!");

        this.hBoxHome = new HBox(10);
        String unlockedString = "You've unlocked\ndifficulty two!";
        this.unlockedLabel = new Label(unlockedString);

    }

    Button getHomeButton() {
        return homeButton;
    }
    public Label getLabel() {
        return unlockedLabel;
    }
}
