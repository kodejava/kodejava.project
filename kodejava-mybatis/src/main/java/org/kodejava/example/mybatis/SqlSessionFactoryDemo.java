package org.kodejava.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryDemo {
    public static void main(String[] args) throws IOException {
        // A resource file for MyBatis configuration.
        Reader reader = Resources.getResourceAsReader("configuration.xml");

        // Creates an SqlSessionFactoryBuilder. This builder need only 
        // create one time during the application life time.
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // Creates an instance of SqlSessionFactory. This object can be 
        // used to initiate an SqlSession for querying information from 
        // the mapped query.
        SqlSessionFactory factory = builder.build(reader);
        System.out.println("factory = " + factory);
    }
}
