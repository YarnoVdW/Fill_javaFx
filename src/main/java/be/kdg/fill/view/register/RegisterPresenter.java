package be.kdg.fill.view.register;

import be.kdg.fill.model.player.Player;
import be.kdg.fill.view.login.LoginPresenter;
import be.kdg.fill.view.login.LoginView;
import javafx.scene.control.Alert;

public class RegisterPresenter {
    private final RegisterView view;

    public RegisterPresenter(RegisterView view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerBack();
    }

    private void addEventHandlerBack() {
        view.getBackButton().setOnAction(actionEvent -> {
            LoginView loginView = new LoginView();
            LoginPresenter presenter = new LoginPresenter(loginView);
            view.getScene().setRoot(loginView);
            loginView.getScene().getWindow().sizeToScene();
        });
    }

    private void addEventHandlerHome() {

        view.getRegisterButton().setOnAction(actionEvent -> {
            String user = view.getUserTextField().getText();
            String pass = view.getPwField().getText();
            String passherhaal = view.getPwFieldRepeat().getText();

            if (pass.equals(passherhaal)) {
                Player.writeToDatabase(user, pass);
                LoginView loginView = new LoginView();
                LoginPresenter presenter = new LoginPresenter(loginView);
                view.getScene().setRoot(loginView);
                loginView.getScene().getWindow().sizeToScene();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("fout wachtwoord");
                alert.show();
            }

        });
    }
}