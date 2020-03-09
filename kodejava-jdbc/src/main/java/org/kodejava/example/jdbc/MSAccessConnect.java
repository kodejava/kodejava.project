package org.kodejava.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSAccessConnect {
    // If you want to use you ODBC DSN
    //private static final String URL = "jdbc:odbc:TestDB";

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "welcome";
    private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";

    private static final String URL =
        "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\Database\\testdb.mdb;}";

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Do something with the connection here!
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
