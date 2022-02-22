package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Move;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;


public class Bord{
    private Vakje[][] bordLayout;
    private int bordBreedte = 6;
    private int bordHoogte = 6;
    private int teller = 0;
    private List<Move> laatsteZetten = new ArrayList<>();
    private Move laatsteZet = new Move(0,0);

    public Bord() {
        this.bordLayout = new Vakje[bordBreedte][bordHoogte];
        vulBord();
        this.maakPatroon();
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
        Image image = new Image("/Oranje.png");
        for (int i = 1; i < 4; i++) {
            bordLayout[0][i].setBruikbaar(true);
            bordLayout[0][i].setKleur(image);


        }
        for (int i = 0; i < 3; i++) {
            bordLayout[i][3].setBruikbaar(true);
            bordLayout[i][3].setKleur(image);



        }
        for (int i = 3 ; i <6 ; i++) {
            bordLayout[2][i].setBruikbaar(true);
            bordLayout[2][i].setKleur(image);




        }
        for (int i = 3 ; i < 6; i++) {
            bordLayout[i][5].setBruikbaar(true);
            bordLayout[i][5].setKleur(image);



        }
    }
    public boolean isAllowedMove(Move move){
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
        return this.teller == 10;
    }

    public Vakje[][] getBordLayout() {
        return bordLayout;
    }
}
