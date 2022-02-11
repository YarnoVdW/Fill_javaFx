package be.kdg.applicatienaam.model;

public class Zet {
    public static Color color;

    private Move move;

    public Zet(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


    public enum Color{
        RED("x");

        private String waarde;

        Color(String waarde) {
            this.waarde = waarde;
        }

        @Override
        public String toString() {
            return waarde;
        }
    }
}
