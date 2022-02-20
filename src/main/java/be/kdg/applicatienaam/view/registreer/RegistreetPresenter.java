package be.kdg.applicatienaam.view.registreer;

import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
                LoginView loginView = new LoginView();
                LoginPresenter presenter = new LoginPresenter(loginView);
                view.getScene().setRoot(loginView);
                loginView.getScene().getWindow().sizeToScene();
            }
        });
    }
}
