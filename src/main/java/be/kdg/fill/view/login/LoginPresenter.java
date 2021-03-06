
package be.kdg.fill.view.login;

import be.kdg.fill.model.player.Player;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.register.RegisterView;
import be.kdg.fill.view.register.RegisterPresenter;
import javafx.scene.control.Alert;
/**Presenter van het login view, met een aantal methodes om in te loggen en gegevens uit de database te halen*/

public class LoginPresenter {
    private final LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerRegister();

    }
    //event-handler
    private void addEventHandlerHome() {

        view.getSingInBtn().setOnAction(actionEvent -> {


            String userName = view.getUserTextField().getText();
            String userPass = view.getPwField().getText();
            Player player =  new Player();
            boolean flag = player.validate(userName, userPass);
            if(view.getUserTextField().getText().isEmpty()) {
                showAlertEmpty("Username");
            }
            else if(view.getPwField().getText().isEmpty()) {
                showAlertEmpty("Password");
            }
            else if(!flag){
               showAlertWrong();
            } else {
                updateViewHome();
            }
        });
    }

    private void addEventHandlerRegister(){
        view.getRegisterBtn().setOnAction(actionEvent -> updateViewRegister());
    }

    //view updaters
    private void updateViewRegister() {
        RegisterView registerView = new RegisterView();
        RegisterPresenter presenter = new RegisterPresenter(registerView);
        view.getScene().setRoot(registerView);
        registerView.getScene().getWindow().sizeToScene();
    }

    private void updateViewHome() {
        HomeView homeView = new HomeView();
        HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
        view.getScene().setRoot(homeView);
        homeView.getScene().getWindow().sizeToScene();
        Player.setPlayerName(view.getUserTextField().getText());
    }
    private void showAlertEmpty(String type) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(type+" is empty");
        alert.show();
    }
    private void showAlertWrong() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Password or username is wrong");
        alert.show();
    }

}