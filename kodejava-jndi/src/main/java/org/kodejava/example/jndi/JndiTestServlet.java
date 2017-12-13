package org.kodejava.example.jndi;

import javax.naming.InitialContext;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JndiTestServlet extends HttpServlet implements Servlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        // This implementation of doGet method show us an example to use
        // conn obtained in the getConnection() method.
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();

        Connection conn = getConnection();
        if (conn != null) {
            try {
                // A query to get current date time from Oracle database
                String sql = "SELECT SYSDATE FROM DUAL";
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    Date date = rs.getDate("SYSDATE");
                    writer.println("The current date is " + format.format(date));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Get a database connection from the registered data source in the
     * servlet container. To registered the JNDI data source you should
     * refer to your servlet container documentation.
     *
     * @return a database connection
     */
    private Connection getConnection() {
        Connection connection = null;
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context
                .lookup("jdbc/DataSource");
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
