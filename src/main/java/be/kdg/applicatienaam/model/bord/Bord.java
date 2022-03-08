package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Move;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Bord {
    private final Vakje[][] bordLayout;
    private final int BORD_BREEDTE = 6;
    private final int BORD_HOOGTE = 6;
    private int teller = 0;
    private List<Move> laatsteZetten = new ArrayList<>();
    private Move laatsteZet = new Move(0, 0);
    private int patroonTeller = 0;
    private final String PATROON = "/maakPatroon.txt";

    public Bord() throws FileNotFoundException, URISyntaxException {
        this.bordLayout = new Vakje[BORD_BREEDTE][BORD_HOOGTE];
        vulBord();
        this.maakPatroon();
    }


    public void vulBord() {
        for (int i = 0; i < BORD_BREEDTE; i++) {
            for (int j = 0; j < BORD_HOOGTE; j++) {
                this.bordLayout[i][j] = new Vakje();

            }
        }
    }
    public void printBord() {
        for (int i = 0; i < BORD_BREEDTE; i++) {
            for (int j = 0; j < BORD_HOOGTE; j++) {
                System.out.print(bordLayout[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void maakPatroon() throws FileNotFoundException, URISyntaxException {
        Image image = new Image("/Oranje.png");
        Image beginImage = new Image("/white.png");
        String lijn = null;
        URL url = getClass().getResource("/maakPatroon.txt");
        Path path = Paths.get(url.toURI());
        File file = path.toFile();
        String[] coordinatenString;

        this.bordLayout[0][0].setKleur(beginImage);
        this.bordLayout[0][0].setUsed(true);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                lijn = scanner.nextLine();
                coordinatenString = lijn.split("#");

                //Loop through all the coordinates
                for (String getal : coordinatenString) {
                    //Find the X and Y coordinates of this pair
                    String[] split = getal.split(",");

                    int xCoordinate = Integer.parseInt(split[0].trim()),
                            yCoordinate = Integer.parseInt(split[1].trim());

                    Vakje vakje = this.bordLayout[xCoordinate][yCoordinate];
                    vakje.setKleur(image);
                    vakje.setBruikbaar(true);

                }
            }
        }

    }
    public boolean isAllowedMove(Move move){
        return this.getVakje(move).isBruikbaar();
    }

    public boolean isNaast(Move move){
        int rijDiff = Math.abs(this.laatsteZet.getRij() - move.getRij());
        int kolDiff = Math.abs(this.laatsteZet.getKolom() - move.getKolom());
        return (rijDiff == 1 ^ kolDiff == 1) && rijDiff + kolDiff ==1;
    }

    public void setLaatsteZet(Move laatsteZet) {
        this.laatsteZet = laatsteZet;
    }

    private Vakje getVakje(Move move) {
        if (move.getKolom() >= this.bordLayout.length ||
                move.getRij() >= this.bordLayout[move.getKolom()].length) return null;

        return this.bordLayout[move.getKolom()][move.getRij()];
    }
    public boolean maakMove(Move move){
        if(this.isAllowedMove(move) && this.isNaast(move)){
            this.bordLayout[move.getKolom()][move.getRij()].kleurIn();
            this.teller++;
            this.bordLayout[move.getKolom()][move.getRij()].setBruikbaar(false);
            setLaatsteZet(move);
            return true;
        }
        if (!(this.isAllowedMove(move)) || !(this.isNaast(move))) return false;
        return false;
    }
    public boolean isVol() {
        return this.teller == 10;
    }

    public Vakje[][] getBordLayout() {
        return bordLayout;
    }

    public void playSound() {
        if (isVol()) {
            AudioClip clip = new AudioClip(this.getClass().getResource("/complete.mp3").toExternalForm());
            clip.play(0.5f);

        }
    }
}
