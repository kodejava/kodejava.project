package org.kodejava.example.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobDemo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO product_images " +
                "(product_id, name, description, image) VALUES (?, ?, ?, ?)";
            String image = "/uml-distilled-3rd-edition.jpg";

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 InputStream is = BlobDemo.class.getResourceAsStream(image)) {

                stmt.setLong(1, 1L);
                stmt.setString(2, "uml-distilled-3rd-edition.jpg");
                stmt.setString(3, "UML Distilled 3rd Edition");
                stmt.setBinaryStream(4, is);
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
