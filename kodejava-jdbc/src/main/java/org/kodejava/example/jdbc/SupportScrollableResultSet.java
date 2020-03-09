package org.kodejava.example.jdbc;

import java.sql.*;

public class SupportScrollableResultSet {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            DatabaseMetaData meta = connection.getMetaData();

            boolean isForwardOnly = meta.supportsResultSetType(
                ResultSet.TYPE_FORWARD_ONLY);
            System.out.println("ForwardOnly = " + isForwardOnly);

            boolean isScrollInsensitive = meta.supportsResultSetType(
                ResultSet.TYPE_SCROLL_INSENSITIVE);
            System.out.println("ScrollInsensitive = " + isScrollInsensitive);

            boolean isScrollSensitive = meta.supportsResultSetType(
                ResultSet.TYPE_SCROLL_SENSITIVE);
            System.out.println("ScrollSensitive = " + isScrollSensitive);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
