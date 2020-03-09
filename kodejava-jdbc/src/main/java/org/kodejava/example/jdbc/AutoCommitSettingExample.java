package org.kodejava.example.jdbc;

import java.sql.*;

public class AutoCommitSettingExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        // DO: Get a connection to database, we need to obtain the
        // database connection prior to executing any JDBC commands
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Disable the auto-commit operation. By default every statement
            // executed against database in JDBC is in auto-commit mode. To
            // disable auto-commit set it to false
            connection.setAutoCommit(false);

            // DO: Execute some other database operation here
            String sql = "DELETE FROM books WHERE isbn = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "9781617294945");
                statement.executeUpdate();

                // Finally we must call the commit method explicitly to finish
                // all database manipulation operation
                connection.commit();
            } catch (SQLException e) {
                // When some exception occurs rollback the transaction.
                connection.rollback();
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
