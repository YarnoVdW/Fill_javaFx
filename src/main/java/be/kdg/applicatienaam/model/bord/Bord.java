package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.bord.Vakje;

public class Bord {
    private Vakje[][] bordLayout;
    private int bordBreedte = 5;
    private int bordHoogte = 5;

    public Bord() {
        this.bordLayout = new Vakje[bordBreedte][bordHoogte];
    }
    public void vulBord() {
        for (int i = 0; i < bordBreedte; i++) {
            for (int j = 0; j < bordHoogte; j++) {
                bordLayout[i][j]= new Vakje();
                //maakPatroon();
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
            bordLayout[i][0].kleurIn();
        }
        for (int i = 0; i < 3; i++) {
            bordLayout[2][i].kleurIn();
        }
        for (int i = 2 ; i <5 ; i++) {
            bordLayout[i][2].kleurIn();
        }
        for (int i = 2 ; i < 5; i++) {
            bordLayout[4][i].kleurIn();
        }
    }

}
