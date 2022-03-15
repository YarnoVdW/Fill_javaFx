package be.kdg.fill.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {


    private static int levelsPlayed =0;
    private static String playerName;
    private static final ObservableList<Integer> playerLevels = FXCollections.observableArrayList();

    public static void writeToDatabase(String userName, String userPassword) {
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
            Logger lgr = Logger.getLogger(Player.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public boolean validate(String userName, String pass) {
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
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(Player.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        return false;
    }

    public static void setLevelsPlayed(String userName,int levelsPlayed) {
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        String query = "update player set levels = ? where name= ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1,levelsPlayed);
            pst.setString(2, userName);
            Player.levelsPlayed = levelsPlayed;

            pst.execute();
            System.out.println("User level successfully updated");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Player.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public static int getLevelsPlayed() {

        return levelsPlayed;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        Player.playerName = playerName;
    }

    public static ObservableList<Integer> getPlayerLevels() {
        return playerLevels;

    }

    public static void makeLevelList() throws SQLException {

        String Sql = "Select levels from player where name = ?";

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
                        Player.levelsPlayed = pst.getResultSet().getInt(1);
                    }
                    isResult = pst.getMoreResults();
                }
            } while(isResult);

        }
        for (int i = 1; i <= Player.getLevelsPlayed(); i++) {
            if(!playerLevels.contains(i)) playerLevels.add(i);
        }

    }

}



