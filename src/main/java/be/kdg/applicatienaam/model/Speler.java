package be.kdg.applicatienaam.model;
import java.util.Objects;


public class Speler {
    private String gebruikersNaam;
    private long score;
    private String password;
    public Speler(String gebruikersnaam, String password) {
        this.gebruikersNaam = gebruikersNaam;
        this.password = password;
        this.score = score;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speler speler = (Speler) o;
        return score == speler.score && Objects.equals(gebruikersNaam, speler.gebruikersNaam);
    }
    @Override
    public int hashCode() {
        return Objects.hash(gebruikersNaam);
    }

    public int compareTo(Object o) {//spelers comparen op hun scores om zo een highscore bord te kunnen maken
        if(!(o instanceof Speler)) return -1;
        Speler other = (Speler) o;
        int i = this.gebruikersNaam.compareTo(other.gebruikersNaam);
        return (int) (this.score - other.score);
    }
}
