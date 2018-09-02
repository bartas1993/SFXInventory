package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockWindowDbConnectionModel {


    public static Connection getConnection() {
        Connection con = null;
        try {
            String connectToDB = "jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db";
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(connectToDB);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
