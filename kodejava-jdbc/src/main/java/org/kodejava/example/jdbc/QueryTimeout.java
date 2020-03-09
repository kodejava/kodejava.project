package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class QueryTimeout {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = connection.createStatement();

            // Sets the number of seconds the driver will wait for
            // a statement object to execute to the given number of
            // seconds. If the limit is exceeded, an SQLException
            // is thrown.
            stmt.setQueryTimeout(60);

            // Execute sql query
            ResultSet rs = stmt.executeQuery("select * from products");

            while (rs.next()) {
                System.out.println("code: " + rs.getString("code")
                    + " ,product: " + rs.getString("name")
                    + " ,price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
