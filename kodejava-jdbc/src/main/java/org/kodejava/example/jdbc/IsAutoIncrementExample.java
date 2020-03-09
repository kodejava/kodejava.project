package org.kodejava.example.jdbc;

import java.sql.*;

public class IsAutoIncrementExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "SELECT id, username, order_date FROM orders");

            // The ResultSetMetaData is where all metadata related
            // information for a result set is stored.
            ResultSetMetaData metadata = resultSet.getMetaData();
            if (metadata.isAutoIncrement(1)) {
                System.out.println("Column `id` is an auto-increment column.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
