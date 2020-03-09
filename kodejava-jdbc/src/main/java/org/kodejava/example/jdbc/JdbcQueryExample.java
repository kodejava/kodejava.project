package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcQueryExample {
    // Database connection information
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        // Get a connection to database.
        try (Connection connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Create a statement object.
            Statement statement = connection.createStatement();

            // Executes a query command to select isbn and the book title
            // from books table. The execute query returns a ResultSet
            // object which is the result of our query execution.
            String query = "SELECT isbn, title, published_year FROM books";
            ResultSet books = statement.executeQuery(query);

            // To get the value returned by the statement.executeQuery we
            // need to iterate the books object until the last items.
            while (books.next()) {
                // To get the value from the ResultSet object we can call
                // a method that correspond to the data type of the column
                // in database table. In the example below we call
                // books.getString("isbn") to get the book's ISBN
                // information.
                System.out.println(books.getString("isbn") + ", " +
                    books.getString("title") + ", " +
                    books.getInt("published_year"));
            }
        }
    }
}
