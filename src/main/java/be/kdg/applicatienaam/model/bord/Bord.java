package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Move;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;


public class Bord{// extends gridpane?
    private Vakje[][] bordLayout;
    private int bordBreedte = 5;
    private int bordHoogte = 5;
    private int teller = 0;
    private List<Move> laatsteZetten = new ArrayList<>();
    private Move laatsteZet = new Move(0,0);

    public Bord() {
        this.bordLayout = new Vakje[bordBreedte][bordHoogte];
        vulBord();
        maakPatroon();
    }


    public void vulBord() {
        for (int i = 0; i < bordBreedte; i++) {
            for (int j = 0; j < bordHoogte; j++) {
                this.bordLayout[i][j]= new Vakje();

            }
        }
    }
    public void printBord() {
        for (int i = 0; i < bordBreedte; i++) {
            for (int j = 0; j < bordHoogte; j++) {
                System.out.print(bordLayout[i][j]+ " ");
            }
            System.out.println();
        }

    }
    public void maakPatroon(){
        bordLayout[0][0].setKleur(Color.RED);
        for (int i = 1; i < 3; i++) {
            bordLayout[i][0].setBruikbaar(true);
            bordLayout[i][0].setKleur(Color.GRAY);
        }
        for (int i = 0; i < 3; i++) {
            bordLayout[2][i].setBruikbaar(true);
            bordLayout[2][i].setKleur(Color.GRAY);

        }
        for (int i = 2 ; i <5 ; i++) {
            bordLayout[i][2].setBruikbaar(true);
            bordLayout[i][2].setKleur(Color.GRAY);

        }
        for (int i = 2 ; i < 5; i++) {
            bordLayout[4][i].setBruikbaar(true);
            bordLayout[4][i].setKleur(Color.GRAY);

        }
    }
    private boolean isAllowedMove(Move move){
        return this.getVakje(move).isBruikbaar();
    }

    public boolean isNaast(Move move){

        return Math.abs(this.laatsteZet.getRij() - move.getRij()) == 1 ^ Math.abs(this.laatsteZet.getKolom() - move.getKolom()) == 1;
    }

    public void setLaatsteZet(Move laatsteZet) {
        this.laatsteZet = laatsteZet;
    }

    private Vakje getVakje(Move move) {
        return this.bordLayout[move.getKolom()][move.getRij()];
    }
    public boolean maakMove(Move move){
        if(this.isAllowedMove(move) && this.isNaast(move)){
            this.bordLayout[move.getKolom()][move.getRij()].kleurIn();
            this.teller++;
            this.bordLayout[move.getKolom()][move.getRij()].setBruikbaar(false);
            setLaatsteZet(move);

            return true;
        }
        if(!(this.isAllowedMove(move)) || !(this.isNaast(move))) System.out.println("Dit is een verkeerde zet");
        return false;
    }
    public boolean isVol() {
        return this.teller == 8;
    }

    public void maakBordLeeg(){
        for (int i = 0; i < bordBreedte; i++) {
            for (int j = 0; j < bordHoogte; j++) {
                this.bordLayout[i][j] = null;
            }
        }
        this.laatsteZet = new Move(0,0);

        this.teller = 0;
    }



}
