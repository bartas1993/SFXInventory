package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockWindowDbConnectionModel {


    public static Connection getConnection() {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/inventorycontrollfx?verifyServerCertificate=false&useSSL=false","bartoszkepke09","bartoszkepke00099912");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
