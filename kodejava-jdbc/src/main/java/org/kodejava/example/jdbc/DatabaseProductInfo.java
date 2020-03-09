package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DatabaseProductInfo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            DatabaseMetaData metadata = connection.getMetaData();

            String productName = metadata.getDatabaseProductName();
            String productVersion = metadata.getDatabaseProductVersion();
            int majorVersion = metadata.getDatabaseMajorVersion();
            int minorVersion = metadata.getDatabaseMinorVersion();

            System.out.println("Product Name    = " + productName);
            System.out.println("Product Version = " + productVersion);
            System.out.println("Major Version   = " + majorVersion);
            System.out.println("Minor Version   = " + minorVersion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
