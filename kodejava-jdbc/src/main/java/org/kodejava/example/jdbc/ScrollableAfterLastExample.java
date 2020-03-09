package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableAfterLastExample {
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
            ResultSet resultSet = statement.executeQuery(sql);

            // Let's jump to the last records. The afterLast() method will
            // position the cursor after the last record.
            resultSet.afterLast();

            while (resultSet.previous()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                System.out.println(code + "\t" + name + "\t" + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
