# How do I retrieve object from database in Hibernate?

In the [How do I store object in Hibernate?](//kodejava.org/how-do-i-store-object-in-hibernate/) example you'll see how tho store objects into database. In this example we'll extends the `LabelManager` class and add the capability to get or query object from database.

```java
package org.kodejava.example.hibernate.app;

import org.hibernate.Session;
import org.kodejava.example.hibernate.model.Label;

public class LabelManager {
    public Label getLabel(Long id) {
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // We get back Label object from database by calling the Session
        // object get() method and passing the object type and the object
        // id to be read.
        Label label = session.get(Label.class, id);
        session.getTransaction().commit();

        return label;
    }

    public void saveLabel(Label label) {
        // To save an object we first get a session by calling
        // getCurrentSession() method from the SessionFactoryHelper
        // class. Next we create a new transaction, save the Label object
        // and commit it to database,
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(label);
        session.getTransaction().commit();
    }
}
```

```java
package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

public class LoadDemo {
    public static void main(String[] args) {
        // Create an instance of LabelManager.
        LabelManager manager = new LabelManager();
        
        // We call the getLabel() method an pass the label id to load it
        // from the database and print out the label string.
        Label label = manager.getLabel(1L);
        System.out.println("label = " + label);
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
