# How do I find entity by their ID in JPA?

In this example you will learn how to find an entity object by its ID using JPA. To find entity by ID we use the `EntityManager.find()` method and pass the entity class the the entity ID as the parameters.

In the code snippet below the `EntityManager` required by the `ArtistDaoImpl` will be passed from the main program when the DAO is instantiated. The process of finding the Artist entity is defined in the `findById()` method in the DAO class. You must pass the ID of the entity to this method.

The `findById()` method call the `EntityManager.find()` method to find the entity. If no entity is found, where the `artist == null` a `javax.persistence.EntityNotFoundException` will be thrown.

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

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<Artist> getArtists() {
        Query query = manager.createQuery("select a from Artist a", Artist.class);
        return query.getResultList();
    }
}
```

To run the DAO class we create a main program in the code snippet below. The steps is create the `EntityManagerFactory` configured by your [`persistence.xml`](//kodejava.org/how-do-i-create-jpa-entitymanagerfactory#persistence) file. Create the `EntityManager` using the factory object. Create the DAO and pass the `EntityManager` to it. And finally call the `findById()` method of the DAO class.

```java
package org.kodejava.example.jpa;

import org.kodejava.example.jpa.dao.ArtistDao;
import org.kodejava.example.jpa.dao.impl.ArtistDaoImpl;
import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

public class FindEntityByIdDemo {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        ArtistDao dao = new ArtistDaoImpl(em);

        // Find an artist with ID = 1 from the database. The entity is
        // exists in the database.
        Artist artist = dao.findById(1L);
        System.out.println("Artist = " + artist);

        try {
            // Find an entity that is not exists in the database will
            // throw an exception.
            artist = dao.findById(100L);
            System.out.println("Artist = " + artist);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
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

