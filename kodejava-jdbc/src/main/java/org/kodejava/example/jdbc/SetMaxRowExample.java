package org.kodejava.example.jdbc;

import java.sql.*;

public class SetMaxRowExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();

            // Executes an SQL query to get the total number of data
            // in products table.
            String query = "select count(*) from products";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.println("Total Products: " + rs.getInt(1));
            }

            // Set the maximum row of data that can be stored in the
            // ResultSet.
            statement.setMaxRows(5);

            // Executes an SQL query to retrieve data from Products
            // table.
            query = "select id, code, name, price from products";
            rs = statement.executeQuery(query);

            System.out.println("Data read after the MaxRows is set.");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                    + ", CODE: " + rs.getString("code")
                    + ", NAME: " + rs.getString("name")
                    + ", PRICE: " + rs.getBigDecimal("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
