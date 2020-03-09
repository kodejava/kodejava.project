package org.kodejava.example.jdbc;

import java.sql.*;

public class RegisterOutParameter {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // Creates a CallableStatement for executing the stored
            // procedure
            String query = "call GetDetailByName(?, ?, ?)";
            CallableStatement cb = connection.prepareCall(query);

            // Sets the input parameter
            cb.setString(1, "Ruby on Rails");

            // Registers the out parameters
            cb.registerOutParameter(2, Types.VARCHAR);
            cb.registerOutParameter(3, Types.DECIMAL);

            // Executes the query
            cb.executeQuery();

            // Gets the query result output
            System.out.println("Name  : " + cb.getString(1));
            System.out.println("Code  : " + cb.getString(2));
            System.out.println("Price : " + cb.getBigDecimal(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
