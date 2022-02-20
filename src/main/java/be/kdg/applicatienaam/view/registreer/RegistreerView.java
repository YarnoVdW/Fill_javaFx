package be.kdg.applicatienaam.view.registreer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RegistreerView extends GridPane {
    private Label userName;
    private TextField userTextField;
    private Button registreerBtn;
    private HBox hbtn;
    private Text title;
    private Label password;
    private PasswordField pwField;
    private PasswordField pwFieldHerhaal;
    private Label passwordHerhaal;

    public RegistreerView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void layoutNodes() {
        this.add(userName, 0,1);
        this.add(userTextField, 1, 1);
        this.hbtn.getChildren().add(registreerBtn);
        this.hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        this.add(hbtn, 1, 4);
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        this.title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(title, 0, 0, 2, 1);
        this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
        //this.setStyle("-fx-background-image: url('/fill-line-game.png')");
        this.setMinSize(200,200);
        this.add(password, 0, 2);
        this.add(pwField,1, 2);
        this.add(pwFieldHerhaal, 1, 3);
        this.add(passwordHerhaal, 0, 3);
    }

    private void initialiseNodes() {
        this.userName = new Label("User name:");
        this.userTextField = new TextField();
        this.registreerBtn = new Button("Register");
        this.hbtn = new HBox(10);
        this.title = new Text("Welcome to Fill");
        this.password = new Label("Password:");
        this.pwField = new PasswordField();
        this.pwFieldHerhaal = new PasswordField();
        this.passwordHerhaal = new Label("Repeat password:");
    }

    public Button getRegistreerBtn() {
        return registreerBtn;
    }
}
