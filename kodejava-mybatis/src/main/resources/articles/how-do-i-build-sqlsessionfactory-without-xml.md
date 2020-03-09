# How do I build SqlSessionFactory without XML?

MyBatis comes with a complete configuration classes that allows us to create a configuration object programmatically without using the XML file. In this code snippet you'll see how to create a `SqlSessionFactory` object without XML configuration file.

We start by obtaining a `javax.sql.DataSource` object. Then we create a `TransactionFactory` object. With these two objects we can then create an `Environment` object and specify its name, such as development, for development environment. The final step is to create the `Configuration` object using the previously created environment.

In the `Configuration` object we can define information such as the type aliases and register all the MyBatis mappers.

```java
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
```

Below are the other supporting classes for the code above, `Record` and `RecordMapper`.

```java
package org.kodejava.example.mybatis.annotation;

import org.apache.ibatis.annotations.Select;
import org.kodejava.example.mybatis.domain.Record;

public interface RecordMapper {
    /**
     * Get a single Record from the database based on the record
     * identified.
     *
     * @param id record identifier.
     * @return a record object.
     */
    @Select("SELECT * FROM records WHERE id = #{id}")
    Record getRecord(Long id);
}
```

```java
package org.kodejava.example.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {
    private Long id;
    private String title;
    private Date releaseDate;
    private Long artistId;
    private Long labelId;

    // Getters & Setters

    @Override
    public String toString() {
        return "Record{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            ", artistId=" + artistId +
            ", labelId=" + labelId +
            '}';
    }
}
```

**Maven Dependencies**

```xml
<dependencies>
    <!--https://search.maven.org/remotecontent?filepath=org/mybatis/mybatis/3.5.0/mybatis-3.5.0.jar-->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.0</version>
    </dependency>
    <!--https://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <!--https://search.maven.org/remotecontent?filepath=org/apache/commons/commons-dbcp2/2.5.0/commons-dbcp2-2.5.0.jar-->
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-dbcp2</artifactId>
        <version>2.5.0</version>
    </dependency>
</dependencies>
```

[![Maven Central](https://img.shields.io/maven-central/v/org.mybatis/mybatis.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.mybatis%22%20AND%20a:%22mybatis%22)
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.commons/commons-dbcp2.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.apache.commons%22%20AND%20a:%22commons-dbcp2%22)
