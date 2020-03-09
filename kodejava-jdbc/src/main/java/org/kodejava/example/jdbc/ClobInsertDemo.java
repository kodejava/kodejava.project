package org.kodejava.example.jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClobInsertDemo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO book_excerpts " +
                "(book_isbn, description, data) VALUES (?, ?, ?)";

            File data = new File("java-8-in-action.txt");
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 FileReader reader = new FileReader(data)) {

                stmt.setString(1, "9781617291999");
                stmt.setString(2, "Java 8 in Action");
                stmt.setCharacterStream(3, reader, (int) data.length());
                stmt.execute();

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
