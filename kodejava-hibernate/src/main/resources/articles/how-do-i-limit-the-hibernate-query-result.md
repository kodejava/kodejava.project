# How do I limit the Hibernate query result?

In the example below you'll see how to limit the number of records returned by the Hibernate queries. Limiting the query result usually used from created a pagination result where we can navigate from page to page in our application data but only a few data are read from the database.

In the Hibernate's `Query` object we need to specify the first result and max results by calling the `setFirstResult()` and `setMaxResults()` methods.

```java
package org.kodejava.example.hibernate.app;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.kodejava.example.hibernate.model.Label;

import java.util.List;

public class LabelManager {

    public List<Label> getLabels(int pageNumber, int pageSize) {
        Session session = 
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Label> query = session.createQuery("from Label", Label.class);

        // Set the first record position and the max number of record to be
        // read. The setFirstResult() tell hibernate from which row the data
        // should be read. In the example if we have pages of 10 records,
        // passing the page number 2 will read 10 records from the 20th row
        // in the selected records.
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Label> labels = query.list();
        session.getTransaction().commit();
        return labels;
    }
}
```

```java
package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

import java.util.List;

public class LimitDemo {
    public static void main(String[] args) {
        LabelManager manager = new LabelManager();

        List<Label> labels = manager.getLabels(1, 10);
        for (Label label : labels) {
            System.out.println("Label = " + label);
        }
    }
}
```

**Maven Dependencies**

```xml
<dependencies>
    <!--https://search.maven.org/remotecontent?filepath=org/hibernate/hibernate-core/5.4.1.Final/hibernate-core-5.4.1.Final.jar-->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.4.1.Final</version>
    </dependency>
    <!--https://search.maven.org/remotecontent?filepath=org/hibernate/hibernate-ehcache/5.4.1.Final/hibernate-ehcache-5.4.1.Final.jar-->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-ehcache</artifactId>
        <version>5.4.1.Final</version>
    </dependency>
    <!--https://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
</dependencies>
```

[![Maven Central](https://img.shields.io/maven-central/v/org.hibernate/hibernate-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.hibernate%22%20AND%20a:%22hibernate-core%22)
[![Maven Central](https://img.shields.io/maven-central/v/org.hibernate/hibernate-ehcache.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.hibernate%22%20AND%20a:%22hibernate-ehcache%22)
