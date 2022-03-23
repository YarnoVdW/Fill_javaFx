/**LevelChooseView klasse, bepaalt hoe de view er moet uitzien wanneer men een level kiest*/

package be.kdg.fill.view.levelchooser;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.sql.SQLException;

public class LevelChooseView extends GridPane {

    private HBox hBoxLabel;
    private HBox hBoxComboBox;
    private Button homeButton;
    private HBox hBoxHome;
    private Label label;
    private ComboBox<Integer> comboBox;

    public LevelChooseView() throws SQLException {
        this.initialiseNodes();
        this.layoutNodes();
        this.getStylesheets().add("style.css");
    }

    private void initialiseNodes() throws SQLException {
        this.hBoxLabel = new HBox(10);
        this.hBoxComboBox = new HBox(10);

        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.hBoxHome = new HBox(10);
        this.label = new Label("Select level");
        this.comboBox = new ComboBox();
    }

    private void layoutNodes() {

        this.hBoxComboBox.setAlignment(Pos.CENTER);
        this.hBoxLabel.setAlignment(Pos.CENTER);
        this.add(hBoxLabel, 0, 1);
        this.add(hBoxComboBox, 0, 3);
        this.setVgap(15);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));
        int GRID_PANE_HEIGHT = 200;
        int GRID_PANE_WIDTH = 200;
        this.setMinSize(GRID_PANE_WIDTH, GRID_PANE_HEIGHT);
        this.hBoxHome.getChildren().add(homeButton);
        this.hBoxHome.setAlignment(Pos.TOP_RIGHT);
        this.add(hBoxHome, 0, 2);
        this.homeButton.setMaxSize(5, 5);
        this.label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(label, HPos.CENTER);
        this.hBoxComboBox.getChildren().add(comboBox);
        this.hBoxLabel.getChildren().add(label);
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public ComboBox<Integer> getComboBox() {
        return comboBox;
    }

}
