# How do I retrieve a list of Hibernate's persistent objects?

In this example we add the function to read a list of records in our `LabelManager` class. This function will read all `Label` persistent object from database. You can see the other functions such as `saveLabel`, `getLabel` and `deleteLabel` in the related example section of this example.

```java
package org.kodejava.example.hibernate.app;

import org.hibernate.Query;
import org.hibernate.Session;
import org.kodejava.example.hibernate.model.Label;

import java.util.List;

public class LabelManager {

    public List<Label> getLabels() {
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // We read labels record from database using a simple Hibernate
        // query, the Hibernate Query Language (HQL).
        List<Label> labels = session.createQuery("from Label", Label.class)
            .list();
        session.getTransaction().commit();

        return labels;
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

import java.util.Date;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        LabelManager manager = new LabelManager();

        // Creates a Label object we are going to stored in the database.
        // We set the name, modified by and modified date information.
        Label newLabel = new Label();
        newLabel.setName("PolyGram");
        newLabel.setCreated(new Date());

        // Call the LabelManager saveLabel method.
        manager.saveLabel(newLabel);

        List<Label> labels = manager.getLabels();
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
