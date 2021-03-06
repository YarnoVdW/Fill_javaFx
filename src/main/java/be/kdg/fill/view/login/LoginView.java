package be.kdg.fill.view.login;

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

/**Bijhorende view van de login presenter, laat een simpel login form zien*/
public class LoginView extends GridPane {
    private Label userName;
    private TextField userTextField;
    private Button singInBtn;
    private HBox hBox;
    private Text title;
    private Label password;
    private PasswordField pwField;
    private Button registerBtn;

    public LoginView () {
        this.initialiseNodes();
        this.layoutNodes();

    }

    public void initialiseNodes(){
        this.userName = new Label("User name:");
        this.userTextField = new TextField();
        this.singInBtn = new Button("Sign in");
        this.hBox = new HBox(10);
        this.title = new Text("Welcome to Fill");
        this.password = new Label("Password:");
        this.pwField = new PasswordField();
        this.registerBtn = new Button("register");

    }
    public void layoutNodes(){
        this.add(userName, 0,1);
        this.add(userTextField, 1, 1);
        this.hBox.getChildren().add(singInBtn);
        this.hBox.setAlignment(Pos.BOTTOM_RIGHT);
        this.add(hBox, 1, 4);
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        this.title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(title, 0, 0, 2, 1);
        this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMinSize(200,200);
        this.add(password, 0, 2);
        this.add(pwField,1, 2);
        this.hBox.getChildren().add(registerBtn);


    }
    Button getSingInBtn() {
        return singInBtn;
    }
    Button getRegisterBtn() {
        return registerBtn;
    }

    TextField getUserTextField() {
        return userTextField;
    }

    PasswordField getPwField() {
        return pwField;
    }
}
