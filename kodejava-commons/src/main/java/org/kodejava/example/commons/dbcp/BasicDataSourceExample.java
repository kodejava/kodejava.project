package org.kodejava.example.commons.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasicDataSourceExample {
    public static void main(String[] args) throws Exception {
        // Creates a BasicDataSource and defines its properties
        // including the driver class name, jdbc url, username
        // and password.
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/kodejava");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        // Get a connection from the data source and do some
        // database query with the obtained connection.
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM authors")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
