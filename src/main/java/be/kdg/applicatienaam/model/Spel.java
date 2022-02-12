package be.kdg.applicatienaam.model;

import be.kdg.applicatienaam.model.bord.Bord;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Spel {
    private final Speler speler;
    private final List<Speler> spelerList = new ArrayList<>();

    private final Bord bord;


    public Spel() {
        bord = new Bord();
        speler = new Speler(Zet.Color.RED);
    }

    public void startSpel() {//ik zou hier nog aanpassingen willen maken(nog opsplitsen in andere klassen)
        //bijvoorbeeld een klasse voor de score te berekenen en deze terug te geven ipv dat hier te doen
        Scanner key = new Scanner(System.in);
        System.out.println("Dag, geef uw gebruikersnaam: ");
        String gebruikersNaam = key.nextLine();
        speler.setGebruikersNaam(gebruikersNaam);
        LocalTime timeOne = LocalTime.now();
        bord.printBord();
        while(!bord.isVol()) {
            speler.play(bord);
            bord.printBord();
        }
        LocalTime timeTwo = LocalTime.now();
        Duration tijdsduur = Duration.between(timeOne, timeTwo);
        int seconds = (int) tijdsduur.getSeconds();
        spelerList.add(new Speler(gebruikersNaam, seconds));

        if (bord.isVol()) {
            System.out.println("Gewonnen\nCongratz "+speler.getGebruikersNaam()+"\nJe hebt het patroon in "+ seconds+" seconden ingevuld.");
            System.out.println("Highscore zien?(0 is ja, 1 is nee)");
            int antwoord = key.nextInt();
            if (antwoord == 0) System.out.println(showHighscores()+"\nHoogste score:\n"+showHighestScore());
            System.out.println("nog een keertje?(ja/nee)");
            String herstart = key.next();
            if (herstart.equalsIgnoreCase("ja")) herstartSpel();

        }


    }
    public void selecteerLevel() {

    }
    public void herstartSpel() {//werkt nog niet
        bord.maakBordLeeg();
        bord.vulBord();
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
                "speler=" + speler + '}';
    }
}
