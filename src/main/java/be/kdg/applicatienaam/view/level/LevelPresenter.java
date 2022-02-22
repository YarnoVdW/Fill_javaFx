package be.kdg.applicatienaam.view.level;

import be.kdg.applicatienaam.model.Move;
import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.levelComplete.LevelCompletePresenter;
import be.kdg.applicatienaam.view.levelComplete.LevelCompleteView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LevelPresenter {
    private LevelView view;
    private Bord bord;


    public LevelPresenter(LevelView view, Bord bord) {
        this.view = view;
        addEventHandler();
        this.bord = new Bord();
        this.bord.maakPatroon();
        this.vulBord();
        addEventHandlerHerstart();


    }

    private void addEventHandler(){
        view.addEventHandler(MouseEvent.MOUSE_DRAGGED, e ->{
            int moveX = (int) (e.getX()/50);
            int moveY = (int)(e.getY()/50);
            Move move = new Move(moveY, moveX);
            System.out.println(e.getX());
            System.out.println(e.getY());
            if(bord.isAllowedMove(move) && bord.isNaast(move)) {

                view.setPosition(bord.getBordLayout()[moveY][moveX].kleurIn(), moveX, moveY);
            }
            bord.maakMove(move);
            if(bord.isVol()){
                bord.playSound();
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
                view.setPosition(bord.getBordLayout()[i][j].geefKleur(), i , j);
            }

        }

    }
    private void updateView(){

    }
    private void addEventHandlerHerstart(){
        view.getHerstart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                herstart();
            }
        });
    }
    private void herstart(){
        LevelView view = new LevelView();
        Bord bord = new Bord();
        bord.vulBord();
        bord.maakPatroon();
        bord.setTeller(0);
    }
}
