package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Types;
import java.sql.SQLException;

public class WasNullExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Prepares a call to the sored procedure
            String query = "call GetProductByPrice2(?, ?)";
            CallableStatement cb = connection.prepareCall(query);

            // Sets the input parameter
            cb.setDouble(1, 40d);

            // Registers the OUT parameter
            cb.registerOutParameter(2, Types.VARCHAR);

            // Executes the query
            cb.executeQuery();

            // Gets the OUT parameter value
            cb.getString(2);

            // Checks if the last OUT parameter has value of SQL NULL.
            // This method should be called only after calling a
            // getter method; otherwise, there is no value to use in
            // determining whether it is null or not.
            if (cb.wasNull()) {
                System.out.println("Product has an SQL NULL value");
            } else {
                System.out.println("Product: " + cb.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
