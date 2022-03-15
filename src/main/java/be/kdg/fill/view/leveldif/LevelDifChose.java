package be.kdg.fill.view.leveldif;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelDifChose extends GridPane {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private HBox hBox;
    private HBox hBox2;
    private Button homeButton;
    private HBox hbox3;
    private ToggleButton soundButton;
    private Label label;

    public LevelDifChose(){
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.hBox = new HBox(10);
        this.hBox2 = new HBox(10);
        this.btn1 = new Button("1");
        this.btn2 = new Button("2");
        this.btn3 = new Button("3");
        this.btn4 = new Button("4");
        this.btn5 = new Button("5");
        this.btn6 = new Button("6");
        this.btn7 = new Button("7");
        this.btn8 = new Button("8");
        this.btn9 = new Button("9");
        this.btn10 = new Button("10");
        this.homeButton = new Button("",new ImageView("/homeButton.png"));
        this.hbox3 = new HBox(10);
        this.soundButton = new ToggleButton("", new ImageView("/soundOn.png"));
        this.label = new Label("Chose difficulty");
    }

    private void layoutNodes() {
        this.hBox.getChildren().add(btn1);
        this.hBox.getChildren().add(btn2);
        this.hBox.getChildren().add(btn3);
        this.hBox.getChildren().add(btn4);
        this.hBox.getChildren().add(btn5);
        this.hBox2.getChildren().add(btn6);
        this.hBox2.getChildren().add(btn7);
        this.hBox2.getChildren().add(btn8);
        this.hBox2.getChildren().add(btn9);
        this.hBox2.getChildren().add(btn10);
        this.hBox2.setAlignment(Pos.CENTER );
        this.hBox.setAlignment(Pos.CENTER);
        this.add(hBox, 0,2);
        this.add(hBox2,0,3);
        this.setVgap(15);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20,20,20,20));
        int GRID_PANE_HEIGTH = 200;
        int GRID_PANE_WIDTH = 200;
        this.setMinSize(GRID_PANE_WIDTH, GRID_PANE_HEIGTH);
        this.hbox3.getChildren().add(homeButton);
        this.hbox3.setAlignment(Pos.TOP_RIGHT);
        this.add(hbox3, 0,1);
        this.homeButton.setMaxSize(5,5);
        this.hbox3.getChildren().add(soundButton);
        this.add(label, 0,0,3,1);
        this.label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(label, HPos.CENTER);
        this.setMinSize(GRID_PANE_WIDTH, GRID_PANE_HEIGTH);


    }

    public Button getHomeButton() {
        return homeButton;
    }

    public ToggleButton getSoundButton() {
        return soundButton;
    }

    public Button getBtn1() {
        return btn1;
    }
}
