package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnectionSTPFillets {



     static Connection DBConnectSTP() throws ClassNotFoundException {

        Connection con;
        try {
            Class forName;
            forName = Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products");
            System.out.println("Succesfull Connection");
            System.out.println("DATABASE TO STP FILLETS ESTABLISHED FOR TESTING");
            return con;

        } catch (SQLException e) {
            System.out.println("Driver and/or Path ERROR");
            e.printStackTrace();
        }
        finally {
            System.out.println("Application Run");

        }

        return null;
    }



}
