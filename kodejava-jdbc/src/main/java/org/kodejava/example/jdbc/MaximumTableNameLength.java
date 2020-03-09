package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class MaximumTableNameLength {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            DatabaseMetaData metadata = connection.getMetaData();

            // Get the information of maximum length of database table name
            int maxLength = metadata.getMaxTableNameLength();
            System.out.println("Max Table Name Length = " + maxLength);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
