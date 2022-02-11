package be.kdg.applicatienaam.model.bord;

public class Vakje {
    private boolean isBruikbaar;

    private String kleur;

    public Vakje() {
        this.isBruikbaar = true;
        this.kleur = "";
    }
    public void kleurIn() {
        this.kleur = "x";
    }
    public void setBruikbaar(){
        this.isBruikbaar = false;
    }
    public String toString() {
        return kleur;
    }
}
