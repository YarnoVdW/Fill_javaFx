/**View om te registreren*/

package be.kdg.fill.view.register;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RegisterView extends GridPane {
    private Label userName;
    private TextField userTextField;
    private Button registerButton;
    private HBox hBox;
    private Text title;
    private Label password;
    private PasswordField pwField;
    private PasswordField pwFieldRepeat;
    private Label passwordRepeat;
    private Button backButton;

    public RegisterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void layoutNodes() {
        this.add(userName, 0,1);
        this.add(userTextField, 1, 1);
        this.hBox.getChildren().add(registerButton);
        this.hBox.getChildren().add(backButton);
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
        this.add(pwFieldRepeat, 1, 3);
        this.add(passwordRepeat, 0, 3);
    }

    private void initialiseNodes() {
        this.userName = new Label("User name:");
        this.userTextField = new TextField();
        this.registerButton = new Button("Register");
        this.hBox = new HBox(10);
        this.title = new Text("Welcome to Fill");
        this.password = new Label("Password:");
        this.pwField = new PasswordField();
        this.pwFieldRepeat = new PasswordField();
        this.passwordRepeat = new Label("Repeat password:");
        this.backButton = new Button("", new ImageView("/logout.png"));
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public TextField getUserTextField() {
        return userTextField;
    }

    public PasswordField getPwField() {
        return pwField;
    }

    public PasswordField getPwFieldRepeat() {
        return pwFieldRepeat;
    }

    public Button getBackButton() {
        return backButton;
    }
}
