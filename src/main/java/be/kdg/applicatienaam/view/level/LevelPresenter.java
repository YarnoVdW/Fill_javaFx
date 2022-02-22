package be.kdg.applicatienaam.view.level;

import be.kdg.applicatienaam.model.Move;
import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.model.bord.Vakje;
import be.kdg.applicatienaam.view.levelComplete.LevelCompletePresenter;
import be.kdg.applicatienaam.view.levelComplete.LevelCompleteView;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LevelPresenter {
    private LevelView view;
    private Bord bord;


    public LevelPresenter(LevelView view, Bord bord) {
        this.view = view;
        addEventHandler();
        this.bord = new Bord();
        this.bord.maakPatroon();
        this.vulBord();


    }

    private void addEventHandler(){
        view.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            int moveX = (int) (e.getX()/50);
            int moveY = (int)(e.getY()/50);
            Move move = new Move(moveY, moveX);
            System.out.println(e.getX());
            System.out.println(e.getY());
            if(bord.isAllowedMove(move) && bord.isNaast(move)) {

                view.setPosititon(bord.getBordLayout()[moveY][moveX].kleurIn(), moveX, moveY);
            }
            bord.maakMove(move);
            if(bord.isVol()){
                levelComplete();
            }
        });

    }
    private void levelComplete(){
        LevelCompleteView levelCompleteView = new LevelCompleteView();
        LevelCompletePresenter presenter = new LevelCompletePresenter(levelCompleteView);
        view.getScene().setRoot(levelCompleteView);
        levelCompleteView.getScene().getWindow().sizeToScene();
    }
    private void vulBord(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                view.setPosititon(bord.getBordLayout()[i][j].geefKleur(), i , j);
            }

        }

    }
    private void updateView(){

    }



}
