package main.db;

import java.sql.*;

public class DatabaseConfigurator {
    private static final String TBL_PROFILE = "profile";

    public static void createTblProfile() {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_PROFILE + "("
                + "id_profile INT(10) NOT NULL AUTO_INCREMENT, "
                + "last_name VARCHAR(255) NOT NULL, "
                + "first_name VARCHAR(255) NOT NULL, "
                + "photo VARCHAR(45), "
                + "email VARCHAR(45), "
                + "phone_number VARCHAR(45), "
                + "description VARCHAR(45), "
                + "gender VARCHAR(45), "
                + "PRIMARY KEY (id_profile) "
                + ")";
        try {
            executeSql(sql);
            System.out.println("Table \"TBL_PROFILE\" is created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeSql(String sql) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = Connections.geMySQLConnection();
            statement = dbConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

}
