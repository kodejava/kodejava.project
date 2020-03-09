package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBatchExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Turn of the auto-commit mode
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                // And some batch to insert some product information into
                // the product table
                statement.addBatch("INSERT INTO products (code, name) " +
                    "VALUE ('P0000006', 'Championship Manager')");
                statement.addBatch("INSERT INTO products (code, name) " +
                    "VALUE ('P0000007', 'Transport Tycoon Deluxe')");
                statement.addBatch("INSERT INTO products (code, name) " +
                    "VALUE ('P0000008', 'Roller Coaster Tycoon 3')");
                statement.addBatch("INSERT INTO products (code, name) " +
                    "VALUE ('P0000009', 'Pro Evolution Soccer')");

                // To execute a batch command we must call the executeBatch()
                // method.
                int[] updateCounts = statement.executeBatch();

                // Commit our transaction
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
