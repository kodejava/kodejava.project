package org.kodejava.example.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetFetchSizeExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();

            // Set the fetch size to 100.
            statement.setFetchSize(100);

            // Execute the given sql query
            String q = "select id, code, name, price from products";
            ResultSet rs = statement.executeQuery(q);

            while (rs.next()) {
                System.out.println("id:" + rs.getLong("id") +
                    ", code:" + rs.getString("code") +
                    ", name:" + rs.getString("name") +
                    ", price:" + rs.getString("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
