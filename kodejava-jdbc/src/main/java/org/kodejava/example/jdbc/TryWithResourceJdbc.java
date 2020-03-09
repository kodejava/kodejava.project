package org.kodejava.example.jdbc;

import java.sql.*;

public class TryWithResourceJdbc {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {

            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");

                System.out.println("Code: " + code + "; Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
