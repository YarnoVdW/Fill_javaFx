package be.kdg.applicatienaam.model;

import be.kdg.applicatienaam.view.login.LoginPresenter;
import be.kdg.applicatienaam.view.login.LoginView;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgresUser {
    public static void writeToDatabase(String userName, String userPassword) {
        String url = "jdbc:postgresql://localhost:5433/JavaFx";
        String user = "postgres";
        String password = "student";

        String name = userName;
        String pass = userPassword;
        String query = "INSERT INTO player(name, password) VALUES(?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, name);
            pst.setString(2, pass);
            pst.executeUpdate();
            System.out.println("User succesfully created");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaPostgresUser.class.getName());
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
            System.out.println(pst);

            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(JavaPostgresUser.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        return false;
    }
}



