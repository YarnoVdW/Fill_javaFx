package be.kdg.fill.view.levelchoser;



import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.sql.SQLException;

public class LevelChoseView extends GridPane {

    private HBox hBox;
    private HBox hBox2;
    private Button homeButton;
    private HBox hbox3;
    private Label label;
    private ComboBox<Integer> comboBox;

    public LevelChoseView() throws SQLException {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() throws SQLException {
        this.hBox = new HBox(10);
        this.hBox2 = new HBox(10);

        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.hbox3 = new HBox(10);
        this.label = new Label("Choose level");
        this.comboBox = new ComboBox();
    }

    private void layoutNodes() {

        this.hBox2.setAlignment(Pos.CENTER);
        this.hBox.setAlignment(Pos.CENTER);
        this.add(hBox, 0, 2);
        this.add(hBox2, 0, 3);
        this.setVgap(15);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));
        int GRID_PANE_HEIGHT = 200;
        int GRID_PANE_WIDTH = 200;
        this.setMinSize(GRID_PANE_WIDTH, GRID_PANE_HEIGHT);
        this.hbox3.getChildren().add(homeButton);
        this.hbox3.setAlignment(Pos.TOP_RIGHT);
        this.add(hbox3, 0, 1);
        this.homeButton.setMaxSize(5, 5);
        this.add(label, 0, 0, 3, 1);
        this.label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(label, HPos.CENTER);
        this.hBox2.getChildren().add(comboBox);
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public ComboBox<Integer> getComboBox() {
        return comboBox;
    }

}
