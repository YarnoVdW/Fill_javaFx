package be.kdg.applicatienaam.view.registreer;

import be.kdg.applicatienaam.model.JavaPostgresUser;
import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class RegistreetPresenter {
    private RegistreerView view;

    public RegistreetPresenter(RegistreerView view) {
        this.view = view;
        addEventHandlerHome();
    }

    private void addEventHandlerHome() {

        view.getRegistreerBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String user = view.getUserTextField().getText();
                String pass = view.getPwField().getText();
                String passherhaal = view.getPwFieldHerhaal().getText();

                if(pass.equals(passherhaal)) {
                    JavaPostgresUser.writeToDatabase(user, pass);
                    LoginView loginView = new LoginView();
                    LoginPresenter presenter = new LoginPresenter(loginView);
                    view.getScene().setRoot(loginView);
                    loginView.getScene().getWindow().sizeToScene();
                }else if (user.equals(null) || pass.equals(null) || passherhaal.equals(null)){
                    System.out.println(pass);
                    System.out.println(passherhaal);
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("wachtwoord of username mag niet null zijn");
                    alert.show();
                } else {
                    System.out.println(pass);
                    System.out.println(passherhaal);
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("fout wachtwoord");
                    alert.show();
                }
            }
        });
    }
}
