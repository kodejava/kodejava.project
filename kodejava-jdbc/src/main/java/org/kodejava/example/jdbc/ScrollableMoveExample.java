package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableMoveExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // In this example we first create a statement that allows us
            // to go back and forth in the result set object. First we'll
            // iterate the result from beginning to the end.
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT id, code, name, price FROM products";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                print(resultSet);
            }

            System.out.println();

            // Now the result set pointer is placed after the last record.
            // With the previous method of the result set we can now move
            // the pointer backward to the beginning of the result set.
            while (resultSet.previous()) {
                print(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void print(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String code = resultSet.getString("code");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");

        System.out.println(id + "\t" + code + "\t" + name + "\t" + price);
    }
}
