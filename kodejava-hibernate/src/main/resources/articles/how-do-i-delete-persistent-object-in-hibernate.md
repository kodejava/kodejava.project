# How do I delete persistent object in Hibernate?

Continuing the previous example [How do I get object from database in Hibernate?](//kodejava.org/how-do-i-retrieve-object-from-database-in-hibernate/), we now add the delete function in our `LabelManager` class.

```java
package org.kodejava.example.hibernate.app;

import org.hibernate.Query;
import org.hibernate.Session;
import org.kodejava.example.hibernate.model.Label;

import java.util.List;

public class LabelManager {
    public void deleteLabel(Long id) {
        // Load the object to be deleted
        Label label = getLabel(id);

        // We get the current session and delete the Label object from 
        // database.
        Session session = 
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(label);
        session.getTransaction().commit();
    }
}
```

```java
package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

import java.util.Date;

public class DeleteDemo {
    public static void main(String[] args) {
        LabelManager manager = new LabelManager();

        // Creates a Label object we are going to stored in the database.
        // We set the name and created date information.
        Label label = new Label();
        label.setName("Sony Music");
        label.setCreated(new Date());

        // Call the LabelManager saveLabel method.
        manager.saveLabel(label);

        // Read the object back from database.
        label = manager.getLabel(label.getId());
        System.out.println("Label = " + label);

        manager.deleteLabel(label.getId());
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

