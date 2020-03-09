package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MaxConnections {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Get database meta data.
            DatabaseMetaData metaData = connection.getMetaData();

            // Retrieves the maximum number of concurrent
            // connections to this database that are possible.
            // A result of zero means that there is no limit or
            // the limit is not known.
            int max = metaData.getMaxConnections();
            System.out.println("Max concurrent connections: " + max);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
