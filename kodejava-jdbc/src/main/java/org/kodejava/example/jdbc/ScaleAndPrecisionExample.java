package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ScaleAndPrecisionExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            String query = "SELECT id, quantity, price FROM order_details";
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metadata = resultSet.getMetaData();
            int precision = metadata.getPrecision(3);
            int scale = metadata.getScale(3);

            System.out.println("Precision: " + precision);
            System.out.println("Scale    : " + scale);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
