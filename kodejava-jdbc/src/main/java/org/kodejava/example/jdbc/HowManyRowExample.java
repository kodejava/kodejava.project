package org.kodejava.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HowManyRowExample {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/kodejava", "root", "");

            PreparedStatement ps = connection.prepareStatement(
                "UPDATE books SET title = ? WHERE id = ?");
            ps.setString(1, "Java Tutorial 3rd Edition");
            ps.setInt(2, 1);
            int rows = ps.executeUpdate();

            System.out.printf("%d row(s) updated!", rows);
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
