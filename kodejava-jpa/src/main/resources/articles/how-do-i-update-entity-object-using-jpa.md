# How do I update entity object using JPA?

In this example you will learn how to update an entity object in JPA. We use the `EntityManager.merge()` method to update an entity. This method takes the entity to be saved as the parameter and return the merged entity back as the result.

You can see a simple example to the code snippet below. Here is the main program for running the `ArtistDao` class to update the artist data in the database.

```java
package org.kodejava.example.jpa;

import org.kodejava.example.jpa.dao.ArtistDao;
import org.kodejava.example.jpa.dao.impl.ArtistDaoImpl;
import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUpdateDemo {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        ArtistDao dao = new ArtistDaoImpl(em);
        Artist artist = dao.findById(1L);
        System.out.println("Artist = " + artist);

        artist.setName("Bon Jovi");
        dao.update(artist);

        artist = dao.findById(artist.getId());
        System.out.println("Artist = " + artist);
    }
}
```

The `ArtistDao` interface and its implementation `ArtistDaoImpl` class definition.

```java
package org.kodejava.example.jpa.dao;

import org.kodejava.example.jpa.entity.Artist;

import java.util.List;

public interface ArtistDao {
    Artist findById(Long id);

    void save(Artist artist);

    void update(Artist artist);

    List<Artist> getArtists();
}
```

```java
package org.kodejava.example.jpa.dao.impl;

import org.kodejava.example.jpa.dao.ArtistDao;
import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

public class ArtistDaoImpl implements ArtistDao {
    private EntityManager manager;

    public ArtistDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * Find Artist based on the entity Id.
     *
     * @param artistId the artist Id.
     * @return Artist.
     * @throws EntityNotFoundException when no artist is found.
     */
    public Artist findById(Long artistId) {
        Artist artist = manager.find(Artist.class, artistId);
        if (artist == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                + artistId);
        }
        return artist;
    }

    @Override
    public void save(Artist artist) {
        manager.getTransaction().begin();
        manager.persist(artist);
        manager.getTransaction().commit();
    }

    /**
     * Update Artist information.
     *
     * @param artist an Artist to be updated.
     */
    @Override
    public void update(Artist artist) {
        manager.getTransaction().begin();
        manager.merge(artist);
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
