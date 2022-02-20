package be.kdg.applicatienaam.view.level;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.model.bord.Vakje;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class LevelView extends GridPane {
    private Bord bord;
    Node node;

    public LevelView() {

        this.initialiseNodes();
        this.layoutNodes();
    }

    private void layoutNodes() {
        this.bord = new Bord();

    }

    private void initialiseNodes() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            e.getX();
            e.getY();
            //And if applicable
            //e.getZ();
        });
    }

}
