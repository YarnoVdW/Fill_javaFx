package be.kdg.applicatienaam.view.level;

import be.kdg.applicatienaam.model.Move;
import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.levelComplete.LevelCompletePresenter;
import be.kdg.applicatienaam.view.levelComplete.LevelCompleteView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class LevelPresenter {
    private final LevelView view;
    private final Bord bord;


    public LevelPresenter(LevelView view, Bord bord) throws FileNotFoundException, URISyntaxException {
        this.view = view;
        addEventHandler();
        this.bord = new Bord();
        this.bord.maakPatroon();
        this.vulBord();
        addEventHandlerHerstart();
    }
    private void addEventHandler(){
        try {
            view.addEventHandler(MouseEvent.MOUSE_DRAGGED, e ->{
                int moveX = (int) (e.getX()/50);
                int moveY = (int)(e.getY()/50);
                Move move = new Move(moveY, moveX);

                if(bord.isAllowedMove(move) && bord.isNaast(move)) {
                    view.setPosition(bord.getBordLayout()[moveY][moveX].kleurIn(), moveX, moveY);
                }
                bord.maakMove(move);
                if(bord.isVol()){
                    bord.playSound();
                    levelComplete();
                }
            });
        } catch (Exception e) {
            System.out.println();
        }
    }
    private void levelComplete(){
        try {
            LevelCompleteView levelCompleteView = new LevelCompleteView();
            LevelCompletePresenter presenter = new LevelCompletePresenter(levelCompleteView);
            view.getScene().setRoot(levelCompleteView);
            levelCompleteView.getScene().getWindow().sizeToScene();
        } catch (Exception e) { // slechte manier, maar ik heb een rare foutmelding
            System.out.println();
        }

    }
    private void vulBord(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                view.setPosition(bord.getBordLayout()[i][j].geefKleur(), i , j);
            }
        }
    }

    private void addEventHandlerHerstart(){
        view.getHerstart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    herstart();
                } catch (FileNotFoundException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void herstart() throws FileNotFoundException, URISyntaxException {
        LevelView nieuwView = new LevelView();
        Bord bord = new Bord();
        LevelPresenter presenter = new LevelPresenter(nieuwView, bord);
        view.getScene().setRoot(nieuwView);
        nieuwView.getScene().getWindow().sizeToScene();
    }
}
