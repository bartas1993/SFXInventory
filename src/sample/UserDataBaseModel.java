package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDataBaseModel {

    public static Connection connectUsers() throws ClassNotFoundException

    {
        Connection con = null;
        Class.forName("org.sqlite.JDBC");
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
