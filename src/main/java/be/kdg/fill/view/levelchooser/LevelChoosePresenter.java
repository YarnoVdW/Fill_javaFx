package be.kdg.fill.view.levelchooser;

import be.kdg.fill.model.bord.Board;
import be.kdg.fill.view.home.HomeView;
import be.kdg.fill.view.home.HomeViewPresenter;
import be.kdg.fill.view.level.LevelPresenter;
import be.kdg.fill.view.level.LevelView;



public class LevelChoosePresenter {
    private final LevelChooseView view;
    private Board board;
    private final String dif;


    public LevelChoosePresenter(LevelChooseView view, String dif) throws Exception {
        this.view = view;
        this.dif = dif;
        addEventHandlerComboBox();
        addEventHandlerHome();
    }

    private void addEventHandlerComboBox() throws Exception {
        board = new Board(dif);
        view.getComboBox().setOnAction(actionEvent -> {

            LevelView levelView = new LevelView();
            try {
                board = new Board(dif);
                board.setPattern(dif); /*we gebruiken het patroon die is meegegeven in de constructor zodat we de juiste moeilijkheid hebben*/
                board.setCurrentLevel(view.getComboBox().getSelectionModel().getSelectedItem());
                LevelPresenter presenter = new LevelPresenter(levelView, board, dif);

            } catch (Exception e) {
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









