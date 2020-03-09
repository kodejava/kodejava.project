package org.kodejava.example.commons.dbcp;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPoolExample {
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private GenericObjectPool<PoolableConnection> connectionPool = null;

    public DataSource setUp() {
        // Creates a connection factory object which will be use by
        // the pool to create the connection object. We passes the
        // JDBC url info, username and password.
        ConnectionFactory cf = new DriverManagerConnectionFactory(
            ConnectionPoolExample.URL,
            ConnectionPoolExample.USERNAME,
            ConnectionPoolExample.PASSWORD);

        // Creates a PoolableConnectionFactory that will wraps the
        // connection object created by the ConnectionFactory to add
        // object pooling functionality.
        PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, null);
        pcf.setValidationQuery("SELECT 1");

        // Creates an instance of GenericObjectPool that holds our
        // pool of connections object.
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        connectionPool = new GenericObjectPool<>(pcf);
        pcf.setPool(connectionPool);

        return new PoolingDataSource<>(connectionPool);
    }

    private GenericObjectPool getConnectionPool() {
        return connectionPool;
    }

    public static void main(String[] args) throws Exception {
        ConnectionPoolExample demo = new ConnectionPoolExample();
        DataSource dataSource = demo.setUp();
        demo.printStatus();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM authors")) {
            demo.printStatus();

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
            }
        }

        demo.printStatus();
    }

    /**
     * Prints connection pool status.
     */
    private void printStatus() {
        System.out.println("Max   : " + getConnectionPool().getNumActive() + "; " +
                "Active: " + getConnectionPool().getNumActive() + "; " +
                "Idle  : " + getConnectionPool().getNumIdle());
    }
}
