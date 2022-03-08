package be.kdg.applicatienaam.model;

import be.kdg.applicatienaam.model.bord.Bord;
import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Spel {

    private final List<Speler> spelerList = new ArrayList<>();

    private final Bord bord;


    public Spel() throws FileNotFoundException, URISyntaxException {
        bord = new Bord();
    }
    public void startSpel() {
        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(view);
    }

    @Override
    public String toString() {
        return "Spel{" +
                "speler="  + '}';
    }
}
