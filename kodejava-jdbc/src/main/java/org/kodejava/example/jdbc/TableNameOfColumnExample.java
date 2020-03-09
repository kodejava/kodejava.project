package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TableNameOfColumnExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            String query = "SELECT a.id, a.quantity, a.price, c.name "
                + "FROM order_details a "
                + "LEFT JOIN orders b ON a.order_id = b.id "
                + "LEFT JOIN products c on a.product_id = c.id";
            ResultSet resultSet = statement.executeQuery(query);

            // Here we have a query that use multiple table, we then want
            // to know to which table a column is belong to. In the
            // ResultSetMetaData there is a getTableName() method that can
            // do this functionality.
            ResultSetMetaData metadata = resultSet.getMetaData();

            String tableName = metadata.getTableName(1);
            System.out.println("Table name of column `a.id` = " + tableName);

            tableName = metadata.getTableName(4);
            System.out.println("Table name of column `c.name` = " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
