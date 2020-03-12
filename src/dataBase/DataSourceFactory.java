package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceFactory {

    public static Connection getConnexion() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/ContactDB", "root", "root");
        System.out.println("data base connected");
        return connection;
    }

}
