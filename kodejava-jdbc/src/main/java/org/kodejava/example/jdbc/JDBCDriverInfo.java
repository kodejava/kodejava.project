package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JDBCDriverInfo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            DatabaseMetaData metadata = conn.getMetaData();
            String driverName = metadata.getDriverName();
            String driverVersion = metadata.getDriverVersion();
            int majorVersion = metadata.getDriverMajorVersion();
            int minorVersion = metadata.getDriverMinorVersion();

            System.out.println("Driver Name    = " + driverName);
            System.out.println("Driver Version = " + driverVersion);
            System.out.println("Major Version  = " + majorVersion);
            System.out.println("Minor Version  = " + minorVersion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
