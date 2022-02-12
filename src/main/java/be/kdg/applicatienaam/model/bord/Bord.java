package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Move;
import be.kdg.applicatienaam.model.Zet;
import be.kdg.applicatienaam.model.bord.Vakje;

import java.util.Arrays;

public class Bord {
    private Vakje[][] bordLayout;
    private int bordBreedte = 5;
    private int bordHoogte = 5;
    private int teller = 0;

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
        for (int i = 0; i < 3; i++) {
            bordLayout[i][0].setBruikbaar(true);
            bordLayout[i][0].setKleur("X");
        }
        for (int i = 0; i < 3; i++) {
            bordLayout[2][i].setBruikbaar(true);
            bordLayout[2][i].setKleur("X");

        }
        for (int i = 2 ; i <5 ; i++) {
            bordLayout[i][2].setBruikbaar(true);
            bordLayout[i][2].setKleur("X");

        }
        for (int i = 2 ; i < 5; i++) {
            bordLayout[4][i].setBruikbaar(true);
            bordLayout[4][i].setKleur("X");

        }
    }
    private boolean isAllowedMove(Move move){
        return this.getVakje(move).isBruikbaar();
    }

    private Vakje getVakje(Move move) {
        return this.bordLayout[move.getKolom()][move.getRij()];
    }
    public boolean maakMove(Move move){//maakZetJuiste genoemd omdat dit de goede is
        if(this.isAllowedMove(move)){
            this.bordLayout[move.kolom][move.rij].kleurIn();
            this.teller++;
            this.bordLayout[move.kolom][move.rij].setBruikbaar(false);

            return true;
        }
        if(!(this.isAllowedMove(move))) System.out.println("Dit is een verkeerde zet");
        return false;
    }
    public boolean isVol() {
        return this.teller == 9;
    }


}
