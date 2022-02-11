package be.kdg.applicatienaam.model;

import be.kdg.applicatienaam.model.bord.Vakje;

public class Bord {
    private Vakje[][] bordLayout;

    public Bord() {
        this.bordLayout = new Vakje[10][10];
    }
    public void vulBord() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                bordLayout[i][j]= new Vakje();
            }

        }
    }
    public void printBord() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(bordLayout[i][j]);
            }
            System.out.println();
        }

    }
}
