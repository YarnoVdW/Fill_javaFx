package be.kdg.applicatienaam.model.bord;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vakje {
    private boolean isBruikbaar;

    private Image kleur;

    public Vakje() {
        this.isBruikbaar = false;
        //this.kleur = new Image("/Oranje.png");
    }
    public Image kleurIn() {
        return this.kleur = new Image("/VakjeKleur.png");
    }

    public void setKleur(Image kleur) {
        this.kleur = kleur;
    }



    public Image geefKleur() {
        return this.kleur;
    }

    public boolean isBruikbaar() {
        return this.isBruikbaar;
    }

    public void setBruikbaar(boolean bruikbaar) {
        isBruikbaar = bruikbaar;
    }


}
