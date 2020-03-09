package org.kodejava.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class DataSourceDemo {
    private static final String URL = "jdbc:mysql://localhost/mediadb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        // Creates an instance of DriverManagerDataSource and pass it to
        // the JdbcTemplate.
        JdbcTemplate jdbc = new JdbcTemplate(getDataSource());
        System.out.println("DataSource = " + jdbc.getDataSource());

        // After creating a jdbc with a data source inject we can do a
        // database manipulation such as the CRUD operation.
        List records = jdbc.queryForList("SELECT * FROM records");
        for (int i = 0; i < records.size(); i++) {
            System.out.println("Records = " + records.get(i));
        }
    }

    /**
     * Returns a DataSource object for connection to the database.
     *
     * @return a DataSource.
     */
    private static DataSource getDataSource() {
        // Creates a new instance of DriverManagerDataSource and sets the
        // required parameters such as the Jdbc Driver class, Jdbc URL,
        // database user name and password.
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(DataSourceDemo.URL);
        ds.setUsername(DataSourceDemo.USERNAME);
        ds.setPassword(DataSourceDemo.PASSWORD);
        return ds;
    }
}
