package org.kodejava.example.jdbc;

import java.sql.*;

public class StoredProcedureListExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet result = metadata.getProcedures(null, "%", "%");

            System.out.println("Catalog\tSchema\tName");
            while (result.next()) {
                System.out.println(result.getString("PROCEDURE_CAT") +
                    " - " + result.getString("PROCEDURE_SCHEM") +
                    " - " + result.getString("PROCEDURE_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
