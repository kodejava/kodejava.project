package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatementExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Create a statement object.
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO books (isbn, title, published_year) " +
                "VALUES ('9781617291999', 'Java 8 in Action', 2015)";

            // Call an execute method in the statement object
            // and pass the query.
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
