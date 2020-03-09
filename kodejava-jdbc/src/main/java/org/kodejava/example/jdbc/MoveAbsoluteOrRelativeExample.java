package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoveAbsoluteOrRelativeExample {
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
            ResultSet rs = statement.executeQuery(sql);

            // Move to the second row
            rs.absolute(2);
            System.out.println("You are now in: " + rs.getRow());

            // Move 2 records forward from the current position
            // (fourth row)
            rs.relative(2);
            System.out.println("You are now in: " + rs.getRow());

            // Move to the last row in the result set
            rs.absolute(-1);
            System.out.println("You are now in: " + rs.getRow());

            // Move 3 records backward from the current position
            // (second row)
            rs.relative(-3);
            System.out.println("You are now in: " + rs.getRow());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
