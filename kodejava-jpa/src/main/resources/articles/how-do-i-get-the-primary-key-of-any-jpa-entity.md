# How do I get the primary key of any JPA entity?

If you want to get the primary key of any JPA entity object you can use `PersistenceUnitUtil.getIdentifier()` method. This method take a single parameter which is the entity object whose identifier to be read. The `PersistenceUnitUtil` instance can be accessed from the `EntityManagerFactory` object.

If the entity object contains an identifier the `getIdentifier()` method will return the identifier as a `java.lang.Object`. If the entity object does not have an identifier ye it will return `null`.

```java
package org.kodejava.example.jpa;

import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetEntityIdDemo {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();

        // Get object identifier of an exists entity.
        Artist artist = manager.find(Artist.class, 1L);
        if (artist != null) {
            Object identifier =
                factory.getPersistenceUnitUtil().getIdentifier(artist);

            System.out.println("Identifier = " + identifier);
        }

        // Get object identifier of a newly inserted entity.
        Artist newArtist = new Artist();
        newArtist.setName("Bon Jovi");

        manager.getTransaction().begin();
        manager.persist(newArtist);
        manager.getTransaction().commit();

        Object identifier =
            factory.getPersistenceUnitUtil().getIdentifier(newArtist);
        System.out.println("Identifier = " + identifier);
    }
}
```

**Maven Dependencies**

```xml
<dependencies>
    <!-- https://search.maven.org/remotecontent?filepath=javax/persistence/javax.persistence-api/2.2/javax.persistence-api-2.2.jar -->
    <dependency>
        <groupId>javax.persistence</groupId>
        <artifactId>javax.persistence-api</artifactId>
        <version>2.2</version>
    </dependency>
    <!-- https://search.maven.org/remotecontent?filepath=org/hibernate/hibernate-core/5.4.1.Final/hibernate-core-5.4.1.Final.jar -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.4.1.Final</version>
    </dependency>
    <!-- https://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
</dependencies>
```

[![Maven Central](https://img.shields.io/maven-central/v/javax.persistence/javax.persistence-api.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22javax.persistence%22%20AND%20a:%22javax.persistence-api%22)
[![Maven Central](https://img.shields.io/maven-central/v/org.hibernate/hibernate-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.hibernate%22%20AND%20a:%22hibernate-core%22)
[![Maven Central](https://img.shields.io/maven-central/v/mysql/mysql-connector-java.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22mysql%22%20AND%20a:%22mysql-connector-java%22)
