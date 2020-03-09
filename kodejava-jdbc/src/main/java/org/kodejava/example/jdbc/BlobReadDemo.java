package org.kodejava.example.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class BlobReadDemo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "SELECT name, image FROM product_images";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");

                File image = new File(name);
                try (FileOutputStream fos = new FileOutputStream(image)) {
                    byte[] buffer = new byte[1024];

                    // Get the binary stream of our BLOB data
                    InputStream is = rs.getBinaryStream("image");
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
