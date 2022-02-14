package be.kdg.applicatienaam.model;

import java.util.Objects;

public class Move {
    public int rij;
    public int kolom;

    private int beginRij;
    private int beginKolom;
    public Move(int rij, int kolom){
        this.rij = rij;
        this.kolom = kolom;

    }

    public void setBeginRij(int beginRij) {
        this.beginRij = beginRij;
    }

    public void setBeginKolom(int beginKolom) {
        this.beginKolom = beginKolom;
    }

    public int getBeginRij() {
        return beginRij;
    }

    public int getBeginKolom() {
        return beginKolom;
    }

    public boolean isNaast(Move move){
        int rijDiff = Math.abs(getBeginRij()- this.rij);
        int kolDiff = Math.abs(getBeginKolom() - this.kolom);
        return (rijDiff == 1 ^ kolDiff == 1) && rijDiff + kolDiff == 1;//dit moet gelijk zijn aan 1 omdat er een van de twee nul
        //moet zijn, anders krijgen we te maken met illegale diagonale zetten.
        //^ betekent dat er MAAR 1 juist mag zijn, exclusive or, diagonalen checken
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return rij == move.rij && kolom == move.kolom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rij, kolom);
    }

    public int getRij() {
        return rij;
    }

    public int getKolom() {
        return kolom;
    }

}

