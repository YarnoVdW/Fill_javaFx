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

public class LevelView extends GridPane {
    private Button restart;
    private Button homeButton;
    private ToggleButton soundButton;
    private HBox hbtn;
    public LevelView() {

        this.initialiseNodes();
        this.layoutNodes();

    }

    private void layoutNodes() {
        this.setGridLinesVisible(false);
        for (int i = 0; i <6; i++){
            this.getColumnConstraints().add(new ColumnConstraints(50));
            this.getRowConstraints().add(new RowConstraints(50));
        }
        this.add(hbtn, 3, 7);
        this.hbtn.getChildren().add(restart);
        this.hbtn.getChildren().add(homeButton);
        this.hbtn.getChildren().add(soundButton);
        this.hbtn.setAlignment(Pos.BOTTOM_CENTER);
    }
    private void initialiseNodes() {
        this.restart = new Button("", new ImageView("/herstart.png"));
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.soundButton = new ToggleButton("", new ImageView("/soundOn.png"));
        this.hbtn = new HBox(10);
    }
    public void setPosition(Image v, int x, int y) {

        ImageView label = new ImageView(v);
        this.add(label, x, y);
        GridPane.setHalignment(label, HPos.CENTER);

    }

    public Button getRestart() {
        return restart;
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public ToggleButton getSoundButton() {
        return soundButton;
    }
}
