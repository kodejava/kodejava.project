# How do I create MyBatis mapper?

In this examples you will see how to create or define a data mapper using the MyBatis. The mapper will communicate our application with the underlying databases where the data is stored. MyBatis data mapper is defined as an `interface` object. We can either use annotations or the xml mapper to define our database query.

In the first steps we will create a domain object, a simple pojo to store our data in the object world. The attributes / fields of our pojo resemble the structure of our `records` table in the database.

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

Next we define the mapper `interface` code, we'll create a `RecordMapper.java` file that contains a method to get data from the table. At this time the `interface` will be as the following:

```java
package org.kodejava.example.mybatis.persistence;

import org.kodejava.example.mybatis.domain.Record;

public interface RecordMapper {
    /**
     * Get a single Record from the database based on the record
     * identified.
     * 
     * @param id record identifier.
     * @return a record object.
     */
    Record getRecord(Long id);
}
```

After create the `ResultMapper.java` interface we create a `RecordMapper.xml` file that defines the queries used by our mapper. Here is how it looks like:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.kodejava.example.mybatis.persistence.RecordMapper">

    <resultMap id="recordResultMap" type="record">
        <result column="release_date" property="releaseDate"/>
        <result column="artist_id" property="artistId"/>
        <result column="label_id" property="labelId"/>
    </resultMap>

    <select id="getRecord" parameterType="java.lang.Long" resultMap="recordResultMap">
        SELECT
            id,
            title,
            release_date,
            artist_id,
            label_id
        FROM records
        WHERE id = #{id}
    </select>
</mapper>
```

To tell MyBatis about our mapper we need to define the mapper inside MyBatis configuration file (`resources/configuration.xml`). We register the mapper inside the `<mappers>` element of the configuration file.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        <typeAlias alias="record" type="org.kodejava.example.mybatis.domain.Record"/>
    </typeAliases>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost/musicdb"/>
                <property name="username" value="root"/>
                <property name="password" value=""/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="org/kodejava/example/mybatis/mapper/RecordMapper.xml"/>
    </mappers>
</configuration>
```

Finally, we create a simple application to use the data mapper to get record data from the database.

```java
package org.kodejava.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kodejava.example.mybatis.domain.Record;
import org.kodejava.example.mybatis.persistence.RecordMapper;

import java.io.Reader;

public class MusicClient {
    public static void main(String[] args) throws Exception {
        Reader reader = Resources.getResourceAsReader("configuration.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        SqlSession session = factory.openSession();

        try {
            RecordMapper mapper = session.getMapper(RecordMapper.class);
            Record record = mapper.getRecord(1L);
            System.out.println("Record = " + record);
        } finally {
            session.close();
        }
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
