package be.kdg.applicatienaam.model;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import javafx.scene.paint.Color;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Spel {

    private final List<Speler> spelerList = new ArrayList<>();

    private final Bord bord;


    public Spel() {
        bord = new Bord();

    }

    public void startSpel() {
        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(view);
    }
    public void selecteerLevel() {

    }
    public void herstartSpel() {//werkt nog niet


        bord.maakPatroon();
        startSpel();

    }
    public Speler showHighestScore() {
        return null; //Collections.max(spelerList);

    }
    public String showHighscores(){//is nog niet volledig juist, het spel geeft enkel de speler terug die net gespeeld heeft.
        for(Speler spelers : spelerList){
            //Collections.sort(spelerList);
            System.out.printf("%s \n", spelers);
        }
        return "";
    }

    @Override
    public String toString() {
        return "Spel{" +
                "speler="  + '}';
    }
}
