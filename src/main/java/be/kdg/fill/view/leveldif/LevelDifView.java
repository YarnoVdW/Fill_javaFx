package be.kdg.fill.view.leveldif;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelDifView extends GridPane {
    private Button btn1;
    private Button btn2;


    private HBox hBoxLabel;
    private HBox hBoxButtons;
    private Button homeButton;
    private HBox hboxHome;
    private Label label;

    public LevelDifView(){
        this.initialiseNodes();
        this.layoutNodes();
        this.getStylesheets().add("style.css");
    }

    private void initialiseNodes() {
        this.hBoxLabel = new HBox(10);
        this.hBoxButtons = new HBox(10);
        this.btn1 = new Button("1");
        this.btn2 = new Button("2");

        this.homeButton = new Button("",new ImageView("/homeButton.png"));
        this.hboxHome = new HBox(10);
        this.label = new Label("Choose difficulty");
    }

    private void layoutNodes() {
        int GRID_PANE_HEIGTH = 250;
        int GRID_PANE_WIDTH = 250;
        this.hBoxButtons.getChildren().add(btn1);
        this.hBoxButtons.getChildren().add(btn2);
        this.hBoxLabel.setAlignment(Pos.CENTER);

        this.hBoxButtons.setAlignment(Pos.CENTER );
        this.hBoxLabel.getChildren().add(label);

        this.add(hBoxLabel, 0,1);
        this.add(hBoxButtons,0,3);

        this.setVgap(15);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20,20,20,20));

        this.setMinSize(GRID_PANE_WIDTH, GRID_PANE_HEIGTH);
        this.hboxHome.getChildren().add(homeButton);
        this.hboxHome.setAlignment(Pos.TOP_RIGHT);
        this.add(hboxHome, 0,2);
        this.homeButton.setMaxSize(5,5);

        this.label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(label, HPos.CENTER);


    }

    public Button getHomeButton() {
        return homeButton;
    }


    public Button getBtn1() {
        return btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

}
