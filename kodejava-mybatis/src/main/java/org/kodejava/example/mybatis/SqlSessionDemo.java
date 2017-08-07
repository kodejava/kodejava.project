package org.kodejava.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kodejava.example.mybatis.domain.Record;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionDemo {
    public static void main(String[] args) throws IOException {
        SqlSessionDemo demo = new SqlSessionDemo();

        // Build an SqlSessionFactory.
        SqlSessionFactory factory = demo.getSessionFactory();

        // Create an SqlSession by using the factory.openSession() method.
        // It is a good practice to use a try-finally block when working
        // with an SqlSession where you can close the session in the 
        // finally block when it finishes the job.
        try (SqlSession session = factory.openSession()) {
            Record record = session.selectOne("getRecord", 1L);
            System.out.println("Record = " + record);
        }
    }

    /**
     * Build an SqlSessionFactory.
     *
     * @return an SqlSessionFactory.
     * @throws IOException when fail to read the configuration file.
     */
    public SqlSessionFactory getSessionFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader("configuration.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder.build(reader);
    }
}
