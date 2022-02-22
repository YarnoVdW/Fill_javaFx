package be.kdg.applicatienaam.model.bord;

import be.kdg.applicatienaam.model.Move;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Bord{
    private Vakje[][] bordLayout;
    private int bordBreedte = 6;
    private int bordHoogte = 6;
    private int teller = 0;
    private List<Move> laatsteZetten = new ArrayList<>();
    private Move laatsteZet = new Move(0,0);

    public Bord() {
        this.bordLayout = new Vakje[bordBreedte][bordHoogte];
        vulBord();
        this.maakPatroon();
    }


    public void vulBord() {
        for (int i = 0; i < bordBreedte; i++) {
            for (int j = 0; j < bordHoogte; j++) {
                this.bordLayout[i][j]= new Vakje();

            }
        }
    }
    public void printBord() {
        for (int i = 0; i < bordBreedte; i++) {
            for (int j = 0; j < bordHoogte; j++) {
                System.out.print(bordLayout[i][j]+ " ");
            }
            System.out.println();
        }

    }
    public void maakPatroon(){
        Image image = new Image("/Oranje.png");
        Image beginImage = new Image("/white.png");
        this.bordLayout[0][0].setKleur(beginImage);
        for (int i = 1; i < 4; i++) {
            bordLayout[0][i].setBruikbaar(true);
            bordLayout[0][i].setKleur(image);


        }
        for (int i = 0; i < 3; i++) {
            bordLayout[i][3].setBruikbaar(true);
            bordLayout[i][3].setKleur(image);



        }
        for (int i = 3 ; i <6 ; i++) {
            bordLayout[2][i].setBruikbaar(true);
            bordLayout[2][i].setKleur(image);




        }
        for (int i = 3 ; i < 6; i++) {
            bordLayout[i][5].setBruikbaar(true);
            bordLayout[i][5].setKleur(image);



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
        if(!(this.isAllowedMove(move)) || !(this.isNaast(move))) System.out.println("Dit is een verkeerde zet");
        return false;
    }
    public boolean isVol() {
        return this.teller == 10;
    }

    public Vakje[][] getBordLayout() {
        return bordLayout;
    }

    public void maakLeeg(){
        Bord bord = new Bord();
        bord.vulBord();

        this.teller = 0;

    }

    public void setTeller(int teller) {
        this.teller = teller;
    }

    public void playSound(){
        if(isVol()){
            AudioClip clip = new AudioClip(this.getClass().getResource("/complete.mp3").toExternalForm());
            clip.play();

        }
    }
}
