package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Spel;

public class TestBordMain {
    public static void main(String[] args) {
        Bord bord = new Bord();
        Spel spel = new Spel();


        bord.printBord();
        spel.startSpel();

    }

}
