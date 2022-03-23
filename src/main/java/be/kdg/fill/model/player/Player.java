/**Player klasse, deze klasse praat vooral met de database om zo spelers te schrijven en levels op te slaan..
 */

package be.kdg.fill.model.player;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {

    private static int levelDif1 =0;
    private static int levelDif2 = 0;
    private static String playerName;
    private static final ObservableList<Integer> playerLevels = FXCollections.observableArrayList();
    private static final ObservableList<Integer> playerLevels2 = FXCollections.observableArrayList();

    public static void writeToDatabase(String userName, String userPassword) {
        /*Deze methode gaat een speler aanmaken en in het database opslaan */
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        String query = "INSERT INTO player(name, password) VALUES(?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, userName);
            pst.setString(2, userPassword);

            pst.executeUpdate();
            System.out.println("User successfully created");

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Username already exists!");
            alert.show();
        }
    }

    public boolean validate(String userName, String pass) {
        /*Valideren of een speler bestaat, als dit niet is wordt er een foutmelding getoond*/
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        String query = "SELECT * FROM player Where name = ? and password = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, userName);
            pst.setString(2, pass);

            playerName = userName;

            System.out.println(pst);

            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) return true;

        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(Player.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }
        return false;
    }

    public static void setLevelsPlayedDif1(String userName, int levelsPlayed) {
        //levels setten van difficulty 1, in het database is dit de table levels
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        String query = "update player set levels = ? where name= ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1,levelsPlayed);
            pst.setString(2, userName);
            Player.levelDif1 = levelsPlayed;

            pst.execute();
            System.out.println("User level successfully updated");

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("User name already exists!");
            alert.show();
        }
    }
    public static void setLevelsPlayedDif2(String userName, int levelsPlayed) {
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        String query = "update player set level2 = ? where name= ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1,levelsPlayed);
            pst.setString(2, userName);
            Player.levelDif2 = levelsPlayed;

            pst.execute();
            System.out.println("User level2 successfully updated");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Player.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public static void emptyPlayerLevels(String userName)  {
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        String query = "update player set level2 = 0, levels =1 where name= ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {


            pst.setString(1, userName);
            Player.levelDif2 = 0;
            Player.levelDif1 = 1;

            pst.execute();
            System.out.println("User levels successfully emptied");
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Player.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        //Clear all the prev data
        playerLevels.clear();
        playerLevels2.clear();

        for (int i = 1; i <= Player.levelDif1; i++) {
            if(!playerLevels.contains(i)) playerLevels.add(i);
        }

        for (int i = 1; i <= Player.levelDif2; i++) {
            if(!playerLevels2.contains(i)) playerLevels2.add(i);
        }
    }

    public static void makeLevelList() throws SQLException {
        String Sql = "Select levels, level2 from player where name = ?";

        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(Sql)) {
            pst.setString(1, Player.getPlayerName());

            boolean isResult = pst.execute();
            do  {
                try (ResultSet resultSet = pst.getResultSet()) {
                    while(resultSet.next()) {
                        Player.levelDif1 = pst.getResultSet().getInt(1);
                        Player.levelDif2 = pst.getResultSet().getInt(2);
                    }
                    isResult = pst.getMoreResults();
                }
            } while(isResult);

        }
        for (int i = 1; i <= Player.getLevelDif1(); i++) {
            if(!playerLevels.contains(i)) playerLevels.add(i);
        }
        for (int i = 1; i <= Player.getLevelDif2(); i++) {
            if(!playerLevels2.contains(i)) playerLevels2.add(i);
        }


    }
    public static ArrayList<String> getHighScores() throws SQLException {
        String sql = "select name, levels+level2 from player order by 2 desc nulls last fetch first 3 rows only";
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(sql)) {

            ArrayList<String> players = new ArrayList<>();
            boolean isResult = pst.execute();
            do  {
                try (ResultSet resultSet = pst.getResultSet()) {
                    while(resultSet.next()) {
                        players.add(resultSet.getString("name"));
                    }
                    isResult = pst.getMoreResults();
                }
            } while(isResult);

            return players;

        }
    }

    public static int getLevelDif1() {
        return levelDif1;
    }

    public static int getLevelDif2() {
        return levelDif2;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Player.playerName = playerName;
    }

    public static ObservableList<Integer> getPlayerLevels() {
        return playerLevels;
    }

    public static ObservableList<Integer> getPlayerLevels2() {
        return playerLevels2;
    }

}



