package org.kodejava.example.mybatis;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.kodejava.example.mybatis.annotation.RecordMapper;
import org.kodejava.example.mybatis.domain.Record;

import javax.sql.DataSource;

public class BuildSqlSessionFactory {
    public static void main(String[] args) {
        // Get DataSource object.
        DataSource dataSource = BuildSqlSessionFactory.getDataSource();

        // Creates a transaction factory.
        TransactionFactory trxFactory = new JdbcTransactionFactory();

        // Creates an environment object with the specified name, transaction
        // factory and a data source.
        Environment env = new Environment("dev", trxFactory, dataSource);

        // Creates a Configuration object base on the Environment object.
        // We can also add type aliases and mappers.
        Configuration config = new Configuration(env);
        TypeAliasRegistry aliases = config.getTypeAliasRegistry();
        aliases.registerAlias("record", Record.class);

        config.addMapper(RecordMapper.class);

        // Build the SqlSessionFactory based on the created Configuration object.
        // Open a session and query a record using the RecordMapper.
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession session = factory.openSession();

        try {
            RecordMapper mapper = session.getMapper(RecordMapper.class);
            Record record = mapper.getRecord(1L);
            System.out.println("Record = " + record);
        } finally {
            session.close();
        }
    }

    /**
     * Returns a DataSource object.
     *
     * @return a DataSource.
     */
    public static DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/musicdb");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
