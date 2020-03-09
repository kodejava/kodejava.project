package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "CREATE TABLE books (" +
                "  isbn varchar(50) NOT NULL, " +
                "  title varchar(100) DEFAULT NULL, " +
                "  published_year int(11) DEFAULT NULL, " +
                "  price decimal(10,2) DEFAULT NULL, " +
                "  PRIMARY KEY (isbn) " +
                ")";

            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
