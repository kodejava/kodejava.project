# How do I use @Select annotation in MyBatis?

In the previous example <a href="http://www.kodejava.org/examples/797.html" title="How do I create MyBatis mapper?">How do I create MyBatis mapper?</a> you've seen how to use a mapper to get a record from the database. In that example the select query is defined in the mapper xml file. For the same functionality MyBatis also offer a solution to use an annotation for the select query.

In this example we will use the `@Select` annotation to define the query. To map the query result we can use the `@ResultMap` annotation where the value passed to this annotation is the result map `id` that we've defined in the mapper xml file.
Let see an example of a mapper `interface` definition that use an annotation to get a record from database:

```java
package org.kodejava.example.mybatis.annotation;

import org.apache.ibatis.annotations.ResultMap;
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
    @ResultMap("recordResultMap")
    Record getRecord(int id);
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
    <!-- https://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
</dependencies>
```

[![Maven Central](https://img.shields.io/maven-central/v/org.mybatis/mybatis.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.mybatis%22%20AND%20a:%22mybatis%22)
