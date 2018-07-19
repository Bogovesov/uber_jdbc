package main.db;

import java.sql.*;

public class Connections {

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String connectionString = "jdbc:mysql://localhost:3306/uber";
    private static final String login = "root";
    private static final String password = "2010";

    public static Connection geMySQLConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(connectionString, login, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
