/**De klasse move, elke move heeft een colom en een rij
 *
 */
package be.kdg.fill.model.move;

import java.util.Objects;
public class Move {

    public int row;
    public int column;

    public Move(int column, int row) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return row == move.row && column == move.column;
    }

}

