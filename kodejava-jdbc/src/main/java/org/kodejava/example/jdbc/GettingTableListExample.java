package org.kodejava.example.jdbc;

import java.sql.*;

public class GettingTableListExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Gets the metadata of the database
            DatabaseMetaData metaData = connection.getMetaData();
            String[] types = {"TABLE"};

            ResultSet rs = metaData.getTables(null, null, "%", types);
            while (rs.next()) {
                String tableCatalog = rs.getString(1);
                String tableSchema = rs.getString(2);
                String tableName = rs.getString(3);

                System.out.printf("%s - %s - %s%n",
                    tableCatalog, tableSchema, tableName);
            }
        }
    }
}
