package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class IsNullableExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)){

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "SELECT isbn, title, published_year, price FROM books");

            // The ResultSetMetaData is where all metadata related
            // information for a result set is stored.
            ResultSetMetaData metadata = resultSet.getMetaData();
            int nullable = metadata.isNullable(1);

            // Check the nullable status of a column (`isbn`)
            if (nullable == ResultSetMetaData.columnNullable) {
                System.out.println("`isbn` can have a null value.");
            } else if (nullable == ResultSetMetaData.columnNoNulls) {
                System.out.println("`isbn` does not allowed to have a " +
                    "null value.");
            } else if (nullable == ResultSetMetaData.columnNullableUnknown) {
                System.out.println("Nullability unknown.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
