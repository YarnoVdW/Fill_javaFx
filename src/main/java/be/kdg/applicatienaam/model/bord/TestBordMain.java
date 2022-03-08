package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Spel;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class TestBordMain {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Bord bord = new Bord();
        Spel spel = new Spel();
        
        bord.printBord();
        spel.startSpel();

    }

}
