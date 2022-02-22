package be.kdg.applicatienaam.view.level;

import be.kdg.applicatienaam.model.bord.Bord;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class LevelView extends GridPane {
    private Button herstart;




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
        this.add(herstart, 0, 7);
    }
    private void initialiseNodes() {
        this.herstart = new Button("", new ImageView("/herstart.png"));
    }
    public void setPosition(Image v, int x, int y) {

        ImageView label = new ImageView(v);
        this.add(label, x, y);
        GridPane.setHalignment(label, HPos.CENTER);

    }

    public Button getHerstart() {
        return herstart;
    }
}
