package be.kdg.applicatienaam.view.login;

import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import be.kdg.applicatienaam.view.registreer.RegistreerView;
import be.kdg.applicatienaam.view.registreer.RegistreetPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginPresenter {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerRegister();

    }

    private void addEventHandlerHome() {

        view.getSingInBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HomeView homeView = new HomeView();
                HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();

            }
        });
    }

    private void addEventHandlerRegister(){
        view.getRegisterBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RegistreerView registreerView = new RegistreerView();
                RegistreetPresenter presenter = new RegistreetPresenter(registreerView);
                view.getScene().setRoot(registreerView);
                registreerView.getScene().getWindow().sizeToScene();
            }
        });
    }
    private void username(){
        String username = view.getUserTextField().getText();

    }
}