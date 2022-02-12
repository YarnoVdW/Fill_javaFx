package be.kdg.applicatienaam.model;

import java.util.ArrayList;
import java.util.List;

public class Speelbord {
    private boolean contact;

    public static final int BREEDTE = 3;
    public static final int HOOGTE = 3;
    private Zet[][] zetten;
    private Move laatsteZet;
    private List<Move> laatsteZetten = new ArrayList<>();
    private int teller;


    public Speelbord() {
        this.zetten = new Zet[BREEDTE][HOOGTE];
    }

    public String toString() { //deze methode maakt het patroon aan
        StringBuilder printBord = new StringBuilder(" 0 1 2 ");
        printBord.append("\n").append("-".repeat(BREEDTE * 2 + 1)).append("\n");
        for (int i = 0; i < HOOGTE; i++) {
            printBord.append("|");
            for (int j = 0; j < BREEDTE; j++) {
                if (zetten[i][j] != null) {
                    printBord.append(zetten[i][j].getColor().toString()).append("|");
                } else {
                    printBord.append(" ").append("|");
                }

            }
            printBord.append("\n").append("-".repeat(BREEDTE * 2 + 1)).append("\n");
        }
        return printBord.toString();
    }




    public void maakBordLeeg(){//werkt nog niet volledig, het bord wordt wel leeg gemaakt maar de zetten zijn niet correct leeg gemaakt
        this.zetten =new Zet[BREEDTE][ HOOGTE];
        laatsteZetten.removeAll(laatsteZetten);
        laatsteZetten.clear();

    }

    boolean isVol() {
        return this.teller == BREEDTE * (HOOGTE);
    }
}

