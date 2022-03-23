/**Presenter van de view levelchooser, deze klasse selecteert het juiste level op basis van de keuze die wordt gemaakt door de speler*/

package be.kdg.fill.view.levelchooser;

import be.kdg.fill.model.bord.Board;
import be.kdg.fill.model.utilities.FillGameException;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;



public class LevelChoosePresenter {
    private final LevelChooseView view;
    private Board board;


    public LevelChoosePresenter(LevelChooseView view, String pattern) throws FillGameException {
        this.view = view;
        addEventHandlerComboBox(pattern);
        addEventHandlerHome();
    }

    private void addEventHandlerComboBox(String pattern) throws FillGameException {
        board = new Board(pattern);
        view.getComboBox().setOnAction(actionEvent -> {

            LevelView levelView = new LevelView();
            try {
                board = new Board(pattern);
                board.setPattern(pattern); /*we gebruiken het patroon die is meegegeven in de constructor zodat we de juiste moeilijkheid hebben*/
                board.setCurrentLevel(view.getComboBox().getSelectionModel().getSelectedItem());
                LevelPresenter presenter = new LevelPresenter(levelView, board, pattern);

            } catch (FillGameException e) {
                e.printStackTrace();
            }
            view.getScene().setRoot(levelView);
            levelView.getScene().getWindow().sizeToScene();
        });

    }
    private void addEventHandlerHome() {
        view.getHomeButton().setOnAction(actionEvent -> {
            HomeView homeView = new HomeView();
            HomeViewPresenter homeViewPresenter = new HomeViewPresenter(homeView);
            view.getScene().setRoot(homeView);
            homeView.getScene().getWindow().sizeToScene();


        });
    }
}









