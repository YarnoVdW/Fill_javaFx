package be.kdg.applicatienaam.model.bord;

public class Vakje {
    private boolean isBruikbaar;

    private String kleur;

    public Vakje() {
        this.isBruikbaar = false;
        this.kleur = "O";
    }
    public void kleurIn() {
        this.kleur = "X";
    }
    public void setBruikbaar(){
        this.isBruikbaar = true;
    }
    public String toString() {
        return this.kleur;
    }

}
