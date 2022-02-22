package be.kdg.applicatienaam.view.level;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.model.bord.Vakje;
import be.kdg.applicatienaam.view.registreer.RegistreetPresenter;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class LevelView extends GridPane {

    private Node node;
    Bord bord = new Bord();


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


    }

    private void initialiseNodes() {

    }
    public void setPosititon(Image v, int x, int y) {

        ImageView label = new ImageView(v);
        this.add(label, x, y);
        GridPane.setHalignment(label, HPos.CENTER);

    }




}
