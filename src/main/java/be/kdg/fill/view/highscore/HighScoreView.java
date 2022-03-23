/**Highscore view klasse, deze bevat een array list met spelers, de 0e is de speler met het meeste levels gespeeld*/

package be.kdg.fill.view.highscore;

import be.kdg.fill.model.player.Player;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.sql.SQLException;
import java.util.ArrayList;

public class HighScoreView extends GridPane {


    private Label firstLabel;
    private Label secondLabel;
    private Label thirdLabel;

    private Button homeButton;
    private HBox hBox;
    private final ArrayList<String> players = Player.getHighScores();
    private BackgroundImage bImg;

    public HighScoreView() throws SQLException {
        this.initialiseNodes();
        this.layoutNodes();
        this.getStylesheets().add("style.css");
    }

    private void initialiseNodes() {
        this.firstLabel = new Label(players.get(0));
        this.secondLabel = new Label(players.get(1));
        this.thirdLabel = new Label(players.get(2));
        this.homeButton = new Button("", new ImageView("/homeButton.png"));
        this.hBox = new HBox();
        Image podium = new Image("/podium.png");
        bImg = new BackgroundImage(podium,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

    }
    private void layoutNodes() {
        for(int i =0; i < 5; i++){
            this.getColumnConstraints().add(new ColumnConstraints(80));
        }
        for (int i = 0; i < 8; i++) {
            this.getRowConstraints().add(new RowConstraints(55));

        }

        this.setAlignment(Pos.CENTER);
        this.setGridLinesVisible(false);

        this.setPrefSize(300, 300);
        this.add(firstLabel, 2, 1, 3 ,1);

        this.add(secondLabel, 1, 2, 3, 1);

        this.add(thirdLabel, 3,3, 3, 1);
        this.firstLabel.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.secondLabel.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.thirdLabel.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        this.setBackground(new Background(bImg));
        GridPane.setFillWidth(firstLabel, true);
        GridPane.setFillWidth(thirdLabel, true);

        GridPane.setHalignment(firstLabel, HPos.LEFT);
        GridPane.setValignment(firstLabel, VPos.TOP);

        GridPane.setHalignment(secondLabel, HPos.LEFT);
        GridPane.setValignment(secondLabel, VPos.BOTTOM);
        GridPane.setValignment(thirdLabel, VPos.TOP);



        this.add(hBox, 2, 7);
        this.hBox.setAlignment(Pos.CENTER);
        this.hBox.getChildren().add(homeButton);

    }

    public Button getHomeButton() {
        return homeButton;
    }
}
