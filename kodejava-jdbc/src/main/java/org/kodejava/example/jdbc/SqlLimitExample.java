package org.kodejava.example.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlLimitExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Create PreparedStatement to get all data from database.
            String query = "select count(*) from products";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet result = ps.executeQuery();

            int total = 0;
            while (result.next()) {
                total = result.getInt(1);
            }

            System.out.println("Total number of data in database: " +
                total + "\n");

            // Create PreparedStatement to the first 5 records only.
            query = "select * from products limit 5";
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();

            System.out.println("Result fetched with specified limit 5");
            System.out.println("====================================");
            while (result.next()) {
                System.out.println("id:" + result.getInt("id") +
                    ", code:" + result.getString("code") +
                    ", name:" + result.getString("name") +
                    ", price:" + result.getString("price"));
            }

            // Create PreparedStatement to get data from the 4th
            // record (remember the first record is 0) and limited
            // to 3 records only.
            query = "select * from products limit 3, 3";
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();

            System.out.println("\nResult fetched with specified limit 3, 3");
            System.out.println("====================================");
            while (result.next()) {
                System.out.println("id:" + result.getInt("id") +
                    ", code:" + result.getString("code") +
                    ", name:" + result.getString("name") +
                    ", price:" + result.getString("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
