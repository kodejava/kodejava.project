package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSetDemo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Create an updatable result set. It means that instead of
            // using a separate sql command to update the data we can
            // update it directly in the result set object.
            //
            // What makes it updatable is because when creating the
            // statement we ask the connection object to create statement
            // with CONCUR_UPDATABLE. The updatable doesn't need to be
            // TYPE_SCROLL_SENSITIVE, but adding this parameter to the
            // statement enable us to go back and forth to update the data.
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT id, code, name, price FROM products";
            ResultSet rs = statement.executeQuery(query);

            System.out.println("id\tcode\tname\tprice");

            while (rs.next()) {
                System.out.println(rs.getLong("id") + "\t"
                    + rs.getString("code") + "\t"
                    + rs.getString("name") + "\t"
                    + rs.getDouble("price"));
            }

            // Move to the first row and update the result set data. After
            // we update the row value we call the updateRow() method to
            // update the data in the database.
            rs.first();
            rs.updateString("name", "UML Distilled 3rd Edition");
            rs.updateRow();

            // Move to the next result set row and delete the row in the
            // result set and apply it to the database.
            rs.next();
            rs.deleteRow();

            // Insert a new row in the result set object with the
            // moveToInsertRow() method. Supply the information to be
            // inserted and finally call the insertRow() method to insert
            // record to the database.
            rs.moveToInsertRow();
            rs.updateString("code", "P0000010");
            rs.updateString("name", "Data Structures, Algorithms");
            rs.updateDouble("price", 50.99);
            rs.insertRow();

            rs.beforeFirst();
            System.out.println();
            System.out.println("id\tcode\tname\tprice");

            while (rs.next()) {
                System.out.println(rs.getLong("id") + "\t"
                    + rs.getString("code") + "\t"
                    + rs.getString("name") + "\t"
                    + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
