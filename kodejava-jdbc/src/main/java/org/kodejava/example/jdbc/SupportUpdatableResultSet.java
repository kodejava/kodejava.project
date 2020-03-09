package org.kodejava.example.jdbc;

import java.sql.*;

public class SupportUpdatableResultSet {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            DatabaseMetaData meta = connection.getMetaData();

            boolean updatable = meta.supportsResultSetConcurrency(
                ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Updatable ResultSet = " + updatable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
