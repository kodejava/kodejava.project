# How do I persist entity to database in JPA?

In this example you are going to learn how to persist or save an entity object to database table using JPA. We are going to create a data access object (DAO) for persisting an `Artist` entity.

We create a class called `ArtistDaoImpl` with a constructor that accept an `EntityManager` parameter. We provide a couple methods in this DAO such as the `save()` and `getArtist()` methods. These methods are for persisting the entity and retrieve a collection of entities from the database.

To persist object to database we call the `EntityManager.persist()` method with the entity object to be saved as the parameter. We also have to begin and commit the transaction before and after we call the `persist()` method. Here is the code for our DAO and its implementation.

```java
package org.kodejava.example.jpa.dao;

import org.kodejava.example.jpa.entity.Artist;

import java.util.List;

public interface ArtistDao {
    Artist findById(Long id);

    void save(Artist artist);

    List<Artist> getArtists();
}
```

```java
package org.kodejava.example.jpa.dao.impl;

import org.kodejava.example.jpa.dao.ArtistDao;
import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ArtistDaoImpl implements ArtistDao {
    private EntityManager manager;

    public ArtistDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Artist findById(Long id) {
        return manager.find(Artist.class, id);
    }

    @Override
    public void save(Artist artist) {
        manager.getTransaction().begin();
        manager.persist(artist);
        manager.getTransaction().commit();
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<Artist> getArtists() {
        Query query = manager.createQuery("select a from Artist a", Artist.class);
        return query.getResultList();
    }
}
```

To demonstrate the DAO we create a simple program as you can see below. The program start by creating the `EntityManagerFactory` configured by the persistence unit defined in the `persistence.xml` file. From the factory we create the `EntityManager` object which will be passed to the `ArtistDaoImpl`.

After create an instance of the `ArtistDao` we insert some artist record to database by calling the `dao.save()` method. To check that the data successfully stored in the database we call the `dao.getArtists()` to read the data back from the database and print it out to the screen.

```java
package org.kodejava.example.jpa;

import org.kodejava.example.jpa.dao.ArtistDao;
import org.kodejava.example.jpa.dao.impl.ArtistDaoImpl;
import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EntityPersistDemo {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();

        String[] artistNames = {"Bryan Adams", "Mr. Big", "Metallica"};

        ArtistDao dao = new ArtistDaoImpl(manager);

        for (String name : artistNames) {
            Artist artist = new Artist();
            artist.setName(name);
            dao.save(artist);
        }

        List<Artist> artistList = dao.getArtists();
        for (Artist artist : artistList) {
            System.out.println("artist = " + artist);
        }
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
