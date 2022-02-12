package be.kdg.applicatienaam.model;

import java.util.Objects;

public class Move {
    public int rij;
    public int kolom;

    public Move(int rij, int kolom){
        this.rij = rij;
        this.kolom = kolom;
    }

    public boolean isNaast(Move move){
        int rijDiff = Math.abs(move.rij - this.rij);
        int kolDiff = Math.abs(move.kolom - this.kolom);
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

