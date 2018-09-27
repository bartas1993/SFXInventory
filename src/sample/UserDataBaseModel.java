package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDataBaseModel {

    public static Connection connectUsers() throws ClassNotFoundException

    {
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/inventorycontrollfx?verifyServerCertificate=false&useSSL=true","bartoszkepke09","bartoszkepke00099912");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
