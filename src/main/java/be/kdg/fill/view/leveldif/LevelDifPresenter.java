/**Presenter voor het kiezen van één van de twee difficulty's*/

package be.kdg.fill.view.leveldif;


import be.kdg.fill.model.player.Player;
import be.kdg.fill.model.utilities.FillGameException;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.levelchooser.LevelChoosePresenter;
import be.kdg.fill.view.levelchooser.LevelChooseView;

import java.sql.SQLException;


public class LevelDifPresenter {
    private final LevelDifView view;

    public LevelDifPresenter(LevelDifView view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerBtn1();
        addEventHandlerDif2();

    }

    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {
            HomeView homeView = new HomeView();
            HomeViewPresenter presenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();
        });
    }


    private void addEventHandlerBtn1() {
        view.getBtn1().setOnAction(actionEvent -> {
            LevelChooseView levelChoseView = null;
            try {
                levelChoseView = new LevelChooseView();
                Player.makeLevelList();
                levelChoseView.getComboBox().setItems(Player.getPlayerLevels());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LevelChoosePresenter presenter = new LevelChoosePresenter(levelChoseView, "/maakPatroon.txt");
            } catch (FillGameException e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelChoseView);
            levelChoseView.getScene().getWindow().sizeToScene();
        });
    }

    private void addEventHandlerDif2() {
        view.getBtn2().setOnAction(actionEvent -> {
            LevelChooseView levelChoseView = null;
            try {
                levelChoseView = new LevelChooseView();
                Player.makeLevelList();
                levelChoseView.getComboBox().setItems(Player.getPlayerLevels2());

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LevelChoosePresenter presenter = new LevelChoosePresenter(levelChoseView, "/patroonDif2.txt");
            } catch (FillGameException e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelChoseView);
            levelChoseView.getScene().getWindow().sizeToScene();
        });
    }
}
