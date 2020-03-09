package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HowManyRowExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "UPDATE books " +
                "SET title = ?, published_year = ? " +
                "WHERE isbn = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "Java 8 in Action, First Edition");
            ps.setInt(2, 2014);
            ps.setString(3, "9781617291999");
            int rows = ps.executeUpdate();
            System.out.printf("%d row(s) updated!%n", rows);
        }
    }
}
