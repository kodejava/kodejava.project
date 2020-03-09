package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Since JDBC 2.0 (JDK 1.2) a scrollable ResultSet was
            // introduced to the java.sql API family. Using this
            // ResultSet enables us to navigate the result set in
            // forward or backward way.
            //
            // To enable the scrollable ResultSet we need to create
            // a statement object by defining the ResultSet type
            // (ResultSet.TYPE_SCROLL_SENSITIVE,
            // ResultSet.TYPE_SCROLL_INSENSITIVE). If you define the
            // ResultSet type to ResultSet.TYPE_FORWARD_ONLY then you
            // get a regular ResultSet where you can move forward
            // only as in JDBC 1.0
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

            // This result set is a scrollable result set
            String query = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
