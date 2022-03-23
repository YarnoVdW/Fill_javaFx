/**Presenter van het login view, met een aantal methodes om in te loggen en gegevens uit de database te halen*/

package be.kdg.fill.view.login;

import be.kdg.fill.model.player.Player;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.register.RegisterView;
import be.kdg.fill.view.register.RegisterPresenter;
import javafx.scene.control.Alert;

public class LoginPresenter {
    private final LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerRegister();

    }

    private void addEventHandlerHome() {

        view.getSingInBtn().setOnAction(actionEvent -> {

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


            Player player =  new Player();
            boolean flag = player.validate(userName, userPass);
            if(!flag){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Password or username is wrong");
                alert.show();
            } else {
                HomeView homeView = new HomeView();
                HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
                Player.setPlayerName(view.getUserTextField().getText());
            }
        });
    }

    private void addEventHandlerRegister(){
        view.getRegisterBtn().setOnAction(actionEvent -> {
            RegisterView registerView = new RegisterView();
            RegisterPresenter presenter = new RegisterPresenter(registerView);
            view.getScene().setRoot(registerView);
            registerView.getScene().getWindow().sizeToScene();
        });
    }

}