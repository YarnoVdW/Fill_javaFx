package be.kdg.applicatienaam.model;

import java.util.Objects;

public class Move {
    public int rij;
    public int kolom;

    public Move(int rij, int kolom){
        this.rij = rij;
        this.kolom = kolom;

    }

    public int getKolom() {
        return this.kolom;
    }

    public int getRij() {
        return this.rij;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rij, kolom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return rij == move.rij && kolom == move.kolom;
    }

}

