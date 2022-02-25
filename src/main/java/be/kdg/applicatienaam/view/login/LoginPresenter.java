package be.kdg.applicatienaam.view.login;

import be.kdg.applicatienaam.model.JavaPostgresUser;
import be.kdg.applicatienaam.view.home.HomeView;
import be.kdg.applicatienaam.view.home.HomeViewPresenter;
import be.kdg.applicatienaam.view.login.LoginView;
import be.kdg.applicatienaam.view.registreer.RegistreerView;
import be.kdg.applicatienaam.view.registreer.RegistreetPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import java.sql.*;

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

                if(view.getUserTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Username is empty");
                    alert.show();
                    return;
                }
                if(view.getPwField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Password is empty");
                    alert.show();
                    return;
                }
                String userName = view.getUserTextField().getText();
                String userPass = view.getPwField().getText();


                JavaPostgresUser Jdbc =  new JavaPostgresUser();
                boolean flag = Jdbc.validate(userName, userPass);
                if(!flag){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Password or username is wrong");
                    alert.show();
                } else {
                    HomeView homeView = new HomeView();
                    HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
                    view.getScene().setRoot(homeView);
                    homeView.getScene().getWindow().sizeToScene();
                }
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