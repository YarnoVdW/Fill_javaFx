package be.kdg.applicatienaam.model;

import be.kdg.applicatienaam.model.bord.Bord;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Speler {
    private String naam;
    private int leeftijd;
    private String gebruikersNaam;
    private long score;
    Random random = new Random();
    private Zet.Color color;

    public Speler(String gebruikersNaam, int score) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.gebruikersNaam = gebruikersNaam;
        this.score = score;
    }
    public Speler(Zet.Color color) {
        this.color = color;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setGebruikersNaam(String gebruikersNaam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    @Override
    public String toString() {
        return String.format("%-10s%d seconden", gebruikersNaam, score);

    }
    public void play(Bord bord) {
        Scanner keyboard = new Scanner(System.in);
        boolean plaats = false;
        int kolom;
        int rij;


        while (!plaats) {
            System.out.print("welke rij?(0,1,2)(van bove naar beneden): ");
            kolom = keyboard.nextInt();
            System.out.print("welke kolom?(0,1,2)(van rechts naar links): ");
            rij = keyboard.nextInt();
            //plaats = bord.maakZet(new Zet(color), kolom, rij);
            plaats = bord.maakMove(new Move(kolom, rij));


        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speler speler = (Speler) o;
        return leeftijd == speler.leeftijd && score == speler.score && Objects.equals(naam, speler.naam) && Objects.equals(gebruikersNaam, speler.gebruikersNaam) && Objects.equals(random, speler.random) && color == speler.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, leeftijd, gebruikersNaam);
    }


    public int compareTo(Object o) {//spelers comparen op hun scores om zo een highscore bord te kunnen maken
        if(!(o instanceof Speler)) return -1;
        Speler other = (Speler) o;
        int i = this.gebruikersNaam.compareTo(other.gebruikersNaam);
        return (int) (this.score - other.score);
    }
}
