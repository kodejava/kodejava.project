package org.kodejava.example.jdbc;

import java.sql.*;

public class ResultSetExample {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost/kodejava";
        String username = "root";
        String password = "";

        try (Connection connection =
                 DriverManager.getConnection(url, username, password)) {

            String query = "SELECT isbn, title, published_year, price " +
                "FROM books";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Read values using column name
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                int publishedYear = rs.getInt("published_year");

                // Read values using column index
                double price = rs.getDouble(4);

                System.out.printf("%s, %s, %d, %.2f\n", isbn, title,
                    publishedYear, price);
            }
        }
    }
}
