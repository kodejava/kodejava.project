package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbMetadataExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet resultSet =
                metadata.getColumns(null, null, "books", null);

            while (resultSet.next()) {
                String name = resultSet.getString("COLUMN_NAME");
                String type = resultSet.getString("TYPE_NAME");
                int size = resultSet.getInt("COLUMN_SIZE");

                System.out.println("Column name: [" + name + "]; " +
                    "type: [" + type + "]; size: [" + size + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
