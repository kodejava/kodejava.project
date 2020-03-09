package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableIsAfterLastExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT code, name, price FROM products";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // Read all ResultSet data
            }

            // Using the isAfterLast() method we can check if we are
            // at the end of the result set.
            if (resultSet.isAfterLast()) {
                System.out.println("You are at the end of the " +
                    "result set.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
