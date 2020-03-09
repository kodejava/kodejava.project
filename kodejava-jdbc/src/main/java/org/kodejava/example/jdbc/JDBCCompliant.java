package org.kodejava.example.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCCompliant {
    private static final String URL = "jdbc:mysql://localhost/kodejava";

    public static void main(String[] args) {
        try {
            Driver driver = DriverManager.getDriver(URL);

            // Check if the driver is a genuine JDBC compliant driver.
            if (driver.jdbcCompliant()) {
                System.out.println("A genuine JDBC compliant driver");
            } else {
                System.out.println("Not a genuine JDBC compliant driver");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
