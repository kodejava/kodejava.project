package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetadataGetSchema {
    private static final String URL = "jdbc:mysql://localhost";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Gets DatabaseMetaData
            DatabaseMetaData metadata = connection.getMetaData();

            // Retrieves the schema names available in this database
            ResultSet rs = metadata.getCatalogs();

            while (rs.next()) {
                String catalog = rs.getString("TABLE_CAT");
                System.out.println("Catalog: " + catalog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
