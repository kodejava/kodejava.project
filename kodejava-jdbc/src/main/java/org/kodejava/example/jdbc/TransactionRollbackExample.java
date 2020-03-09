package org.kodejava.example.jdbc;

import java.sql.*;

public class TransactionRollbackExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            conn.setAutoCommit(false);

            String query = "INSERT INTO orders (username, order_date) " +
                "VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, "javaduke");
                stmt.setDate(2, new Date(System.currentTimeMillis()));
                stmt.execute();

                ResultSet keys = stmt.getGeneratedKeys();
                int orderId = 1;
                if (keys.next()) {
                    orderId = keys.getInt(1);
                }

                // This is an invalid statement that will cause exception to
                // demonstrate a rollback.
                query = "INSERT INTO order_details (order_id, product_id, " +
                    "quantity, price) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement detailStmt = conn.prepareStatement(query);
                detailStmt.setInt(1, orderId);
                detailStmt.setInt(2, 1);
                detailStmt.setInt(3, 10);
                detailStmt.setDouble(4, 29.99);
                detailStmt.execute();

                // Commit transaction to mark it as a success database operation
                conn.commit();
                System.out.println("Transaction commit...");
            } catch (SQLException e) {
                // Rollback any database transaction due to exception occurred
                conn.rollback();
                System.out.println("Transaction rollback...");
                e.printStackTrace();
            }
        }
    }
}
