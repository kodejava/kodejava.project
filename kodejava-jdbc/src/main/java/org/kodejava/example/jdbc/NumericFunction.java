package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class NumericFunction {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            DatabaseMetaData meta = connection.getMetaData();

            // Get numeric functions supported by database
            String[] functions = meta.getNumericFunctions().split(",\\s*");

            for (String function : functions) {
                System.out.println("Function = " + function);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
