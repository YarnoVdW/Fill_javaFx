/**Presenter voor het kiezen van één van de twee difficulty's*/

package be.kdg.fill.view.leveldif;


import be.kdg.fill.model.player.Player;
import be.kdg.fill.model.utilities.FillGameException;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.levelchooser.LevelChoosePresenter;
import be.kdg.fill.view.levelchooser.LevelChooseView;
import javafx.collections.ObservableList;

import java.sql.SQLException;


public class LevelDifPresenter {
    private final LevelDifView view;

    public LevelDifPresenter(LevelDifView view) {
        this.view = view;
        addEventHandlerHome();
        addEventHandlerBtn1();
        addEventHandlerDif2();

    }
    //event-handlers
    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> updateViewHome());
    }

    private void addEventHandlerBtn1() {
        view.getBtn1().setOnAction(actionEvent -> updateViewDifficulty("/maakPatroon.txt", Player.getPlayerLevels()));
    }

    private void addEventHandlerDif2() {
        view.getBtn2().setOnAction(actionEvent -> updateViewDifficulty("/patroonDif2.txt", Player.getPlayerLevels2()));
    }
    // view updaters
    private void updateViewDifficulty(String pattern, ObservableList<Integer> levels) {
        LevelChooseView levelChoseView = null;
        try {
            levelChoseView = new LevelChooseView();
            Player.makeLevelList();
            levelChoseView.getComboBox().setItems(levels);
            LevelChoosePresenter presenter = new LevelChoosePresenter(levelChoseView, pattern);

        } catch (SQLException  | FillGameException e) {
            e.printStackTrace();
            System.out.println("There seems to be a problem at the buttons in levelDif presenter");
        }
        view.getScene().setRoot(levelChoseView);
        assert levelChoseView != null;
        levelChoseView.getScene().getWindow().sizeToScene();
    }

    private void updateViewHome() {
        HomeView homeView = new HomeView();
        HomeViewPresenter presenter = new HomeViewPresenter(homeView);
        view.getScene().setRoot(homeView);
        homeView.getScene().getWindow().sizeToScene();
    }
}
