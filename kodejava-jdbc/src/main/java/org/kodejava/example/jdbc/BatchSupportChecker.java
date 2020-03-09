package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class BatchSupportChecker {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            DatabaseMetaData metadata = connection.getMetaData();

            // Check to see if the database support batch updates
            boolean isBatchSupported = metadata.supportsBatchUpdates();
            System.out.println("Batch Supported = " + isBatchSupported);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
