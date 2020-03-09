package org.kodejava.example.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Prepares a call to the sored procedure. This SP takes
            // one IN parameter
            String query = "call GetProductByPrice(?)";
            CallableStatement cb = connection.prepareCall(query);

            // Sets the input parameter
            cb.setDouble(1, 40d);

            // Execute the query
            ResultSet rs = cb.executeQuery();

            while (rs.next()) {
                System.out.println("Product: " + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
