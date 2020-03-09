package org.kodejava.example.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class DatabaseSupportedType {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet resultSet = metadata.getTypeInfo();
            while (resultSet.next()) {
                String typeName = resultSet.getString("TYPE_NAME");
                System.out.println("Type Name = " + typeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
