package be.kdg.fill.view.home;

import be.kdg.fill.model.Player;
import be.kdg.fill.view.leveldif.LevelDifPresenter;
import be.kdg.fill.view.leveldif.LevelDifChose;
import be.kdg.fill.view.login.LoginPresenter;
import be.kdg.fill.view.login.LoginView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class HomeViewPresenter {
    private final HomeView view;


    public HomeViewPresenter(HomeView view) {
        this.view = view;
        addEventHandlerInfo();
        updateView();
        addEventHandlerPlay();
        addEventHandlerLogout();
        addEventHandlerResetLevel();
    }

    private void addEventHandlerPlay() {
        view.getPlayButton().setOnAction(actionEvent -> {
            LevelDifChose levelDifChose = new LevelDifChose();
            LevelDifPresenter presenter = new LevelDifPresenter(levelDifChose);
            view.getScene().setRoot(levelDifChose);
            levelDifChose.getScene().getWindow().sizeToScene();
        });
    }

    private void updateView() {
    }

    private void addEventHandlerInfo() {
        view.getInfoButton().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Je begint bij \n" +
                    "het startblokje en probeert in één beweging alle blokjes van \n" +
                    "de vorm te bedekken. Dit doe je door met je muis te klikken en te draggen over het volledige bord.");
            alert.setTitle("Hoe spelen?");
            alert.showAndWait();
        });
    }

    private void addEventHandlerLogout(){
        view.getLogout().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Are you sure?");
            alert.getButtonTypes().clear();
            ButtonType no = new ButtonType("No");
            ButtonType yes = new ButtonType("Yes");
            alert.getButtonTypes().addAll(no, yes);
            alert.showAndWait();
            if (alert.getResult().equals(yes)) {
                Player.setPlayerName(null);
                LoginView loginView = new LoginView();
                LoginPresenter presenter = new LoginPresenter(loginView);
                view.getScene().setRoot(loginView);
                loginView.getScene().getWindow().sizeToScene();
            }
        });
    }
    private void addEventHandlerResetLevel() {
        view.getResetLevel().setOnAction(actionEvent -> {
            Player.emptyPlayerLevels(Player.getPlayerName());
        });
    }

}
