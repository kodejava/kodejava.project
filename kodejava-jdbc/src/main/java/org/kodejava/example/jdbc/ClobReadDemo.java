package org.kodejava.example.jdbc;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.*;

public class ClobReadDemo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "SELECT book_isbn, data FROM book_excerpts";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String bookIsbn = resultSet.getString("book_isbn");
                // Get the character stream of our CLOB file
                Reader reader = resultSet.getCharacterStream("data");

                File file = new File(bookIsbn + ".txt");
                try (FileWriter writer = new FileWriter(file)) {
                    char[] buffer = new char[1];
                    while (reader.read(buffer) > 0) {
                        writer.write(buffer);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
