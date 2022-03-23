/**Elke coordinaat van het bord heeft zijn eigen BoardPiece, dit piece hoort bij deze klasse.
 */
package be.kdg.fill.model.bord;


import javafx.scene.image.Image;
import java.util.Objects;

public class BoardPiece {

    private boolean isUsable = false, used = false;
    private Image color;

    public Image giveColor() {
        this.used = true;
        return this.color = new Image("/VakjeKleur.png");
    }

    public void setColor(Image color) {
        this.color = color;
    }

    public boolean isUsed() {
        return used;
    }


    public Image getColor() {
        return this.color;
    }

    public boolean isUsable() {
        return this.isUsable;
    }

    public void setUsable(boolean bruikbaar) {
        isUsable = bruikbaar;
    }
    @Override
    public String toString() {
        return "BoardPiece{" +
                "isUsable=" + isUsable +
                ", used=" + used +
                ", color=" + color +
                '}';
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPiece that = (BoardPiece) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isUsable, used, color);
    }
}
