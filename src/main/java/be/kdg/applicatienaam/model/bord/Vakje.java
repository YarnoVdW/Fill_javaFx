package be.kdg.applicatienaam.model.bord;

public class Vakje {
    private boolean isBruikbaar;

    private String kleur;

    public Vakje() {
        this.isBruikbaar = false;
        this.kleur = "-";
    }
    public void kleurIn() {
        this.kleur = "X";
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }


    public String toString() {
        return this.kleur;
    }

    public boolean isBruikbaar() {
        return this.isBruikbaar;
    }

    public void setBruikbaar(boolean bruikbaar) {
        isBruikbaar = bruikbaar;
    }
}
