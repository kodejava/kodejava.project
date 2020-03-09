package org.kodejava.example.jdbc;

import java.sql.*;

public class CallableStatementDemo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Create a CallableStatement to execute the GetAllProducts()
            // procedure.
            CallableStatement stmt =
                connection.prepareCall("{CALL GetAllProducts()}");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getLong("id") + "\t"
                    + rs.getString("code") + "\t"
                    + rs.getString("name") + "\t"
                    + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
