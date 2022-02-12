package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Move;

import java.util.ArrayList;
import java.util.List;


public class Bord {
    private Vakje[][] bordLayout;
    private int bordBreedte = 5;
    private int bordHoogte = 5;
    private int teller = 0;
    private List<Move> laatsteZetten = new ArrayList<>();
    private Move laatsteZet;

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
        bordLayout[0][0].setKleur("X");
        for (int i = 1; i < 3; i++) {
            bordLayout[i][0].setBruikbaar(true);
            bordLayout[i][0].setKleur("O");
        }
        for (int i = 0; i < 3; i++) {
            bordLayout[2][i].setBruikbaar(true);
            bordLayout[2][i].setKleur("O");

        }
        for (int i = 2 ; i <5 ; i++) {
            bordLayout[i][2].setBruikbaar(true);
            bordLayout[i][2].setKleur("O");

        }
        for (int i = 2 ; i < 5; i++) {
            bordLayout[4][i].setBruikbaar(true);
            bordLayout[4][i].setKleur("O");

        }
    }
    private boolean isAllowedMove(Move move){
        if(this.laatsteZetten == null) return true;
        boolean reedsGespeeld = !List.of(this.laatsteZetten).contains(move);// gebruikt de equals method van Move
        boolean naastLaatsteZet = move.isNaast(this.laatsteZet);

        return this.getVakje(move).isBruikbaar() && reedsGespeeld && naastLaatsteZet;
    }

    private Vakje getVakje(Move move) {
        return this.bordLayout[move.getKolom()][move.getRij()];
    }
    public boolean maakMove(Move move){
        if(this.isAllowedMove(move)){
            this.bordLayout[move.getKolom()][move.getRij()].kleurIn();
            this.teller++;
            this.bordLayout[move.getKolom()][move.getRij()].setBruikbaar(false);
            this.laatsteZet = move;
            this.laatsteZetten.add(move);

            move.setBeginRij(this.laatsteZet.getRij());
            move.setBeginKolom(this.laatsteZet.getKolom());

            return true;
        }
        if(!(this.isAllowedMove(move))) System.out.println("Dit is een verkeerde zet");
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
        this.teller = 0;
    }


}
