
package be.kdg.fill.view.levelchooser;

import be.kdg.fill.model.board.Board;
import be.kdg.fill.model.utilities.FillGameException;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;


/**Presenter van de view levelchooser, deze klasse selecteert het juiste level op basis van de keuze die wordt gemaakt door de speler*/

public class LevelChoosePresenter {
    private final LevelChooseView view;
    private Board board;


    public LevelChoosePresenter(LevelChooseView view, String pattern) throws FillGameException {
        this.view = view;
        addEventHandlerComboBox(pattern);
        addEventHandlerHome();
        this.board = new Board(pattern);

    }
    //event-handlers
    private void addEventHandlerComboBox(String pattern) throws FillGameException {
        view.getComboBox().setOnAction(actionEvent -> updateViewComboBox(pattern));

    }
    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> updateViewHome());
    }

    //view updaters
    private void updateViewHome() {
        HomeView homeView = new HomeView();
        HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
        view.getScene().setRoot(homeView);
        homeView.getScene().getWindow().sizeToScene();
    }
    private void updateViewComboBox(String pattern) {
        LevelView levelView = new LevelView();
        try {
            board = new Board(pattern);
            board.setPattern(pattern); /*we gebruiken het patroon die is meegegeven in de constructor zodat we de juiste moeilijkheid hebben*/
            board.setCurrentLevel(view.getComboBox().getSelectionModel().getSelectedItem());
            LevelPresenter presenter = new LevelPresenter(levelView, board, pattern);

        } catch (FillGameException e) {
            e.printStackTrace();
            System.out.println("There seems to be a problem at the level choose combobox handler");
        }
        view.getScene().setRoot(levelView);
        levelView.getScene().getWindow().sizeToScene();
    }
}









