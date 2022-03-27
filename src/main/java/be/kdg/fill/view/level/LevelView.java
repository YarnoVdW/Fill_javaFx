
package be.kdg.fill.view.level;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
/**Levelview klasse, deze bepaalt hoe het spel eruit ziet als het spel gespeeld wordt*/

public class LevelView extends GridPane {
    private Button restart;
    private Button homeButton;
    private ToggleButton soundButton;
    private HBox hBox;

    public LevelView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void layoutNodes() {
        for (int i = 0; i <6; i++){
            this.getColumnConstraints().add(new ColumnConstraints(50));
            this.getRowConstraints().add(new RowConstraints(50));
        }

        this.add(hBox, 3, 7);
        this.hBox.getChildren().add(restart);
        this.hBox.getChildren().add(homeButton);
        this.hBox.getChildren().add(soundButton);
        this.hBox.setAlignment(Pos.BOTTOM_CENTER);
    }
    private void initialiseNodes() {
        this.restart = new Button("", new ImageView("/restart.png"));
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.soundButton = new ToggleButton("", new ImageView("/soundOn.png"));
        this.hBox = new HBox(10);
    }

    public void setPosition(Image v, int x, int y) {
        ImageView label = new ImageView(v);
        this.add(label, x, y);
        GridPane.setHalignment(label, HPos.CENTER);

    }

    Button getRestart() {
        return restart;
    }

    Button getHomeButton() {
        return homeButton;
    }

    ToggleButton getSoundButton() {
        return soundButton;
    }
}
