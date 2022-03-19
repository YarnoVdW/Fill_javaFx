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

public class LevelDifChoose extends GridPane {
    private Button btn1;
    private Button btn2;


    private HBox hBox;
    private HBox hBox2;
    private Button homeButton;
    private HBox hbox3;
    private Label label;

    public LevelDifChoose(){
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.hBox = new HBox(10);
        this.hBox2 = new HBox(10);
        this.btn1 = new Button("1");
        this.btn2 = new Button("2");

        this.homeButton = new Button("",new ImageView("/homeButton.png"));
        this.hbox3 = new HBox(10);
        this.label = new Label("Choose difficulty");
    }

    private void layoutNodes() {
        int GRID_PANE_HEIGTH = 250;
        int GRID_PANE_WIDTH = 250;
        this.hBox2.getChildren().add(btn1);
        this.hBox2.getChildren().add(btn2);
        this.hBox.setAlignment(Pos.CENTER);

        this.hBox2.setAlignment(Pos.CENTER );
        this.hBox.getChildren().add(label);

        this.add(hBox, 0,2);
        this.add(hBox2,0,3);

        this.setVgap(15);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20,20,20,20));

        this.setMinSize(GRID_PANE_WIDTH, GRID_PANE_HEIGTH);
        this.hbox3.getChildren().add(homeButton);
        this.hbox3.setAlignment(Pos.TOP_RIGHT);
        this.add(hbox3, 0,1);
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
