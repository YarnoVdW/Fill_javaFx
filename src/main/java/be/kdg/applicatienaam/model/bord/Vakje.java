package be.kdg.applicatienaam.model.bord;


import javafx.scene.paint.Color;

public class Vakje {
    private boolean isBruikbaar;

    private Color kleur;

    public Vakje() {
        this.isBruikbaar = false;
        this.kleur = Color.GREY;
    }
    public void kleurIn() {
        this.kleur = Color.RED;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }


    /*public String toString() {
        return this.kleur;
    }*/

    public boolean isBruikbaar() {
        return this.isBruikbaar;
    }

    public void setBruikbaar(boolean bruikbaar) {
        isBruikbaar = bruikbaar;
    }
}
