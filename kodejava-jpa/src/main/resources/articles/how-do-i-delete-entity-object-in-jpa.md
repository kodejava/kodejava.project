# How do I delete entity object in JPA?

The following code example show you how to delete or remove entity object from database using JPA. The first class that we are going to create is `ArtistDaoImpl` which implements `ArtistDao`. This DAO class handles the delete process either by the entity Id or by the entity object itself. We define the delete process in `deleteById(Long id)` and `delete(Artist artist)` methods.

In those methods we call the `EntityManager.remove()` method. This method of `EntityManager` will taking care of removing the entity object from our database. Let's see the DAO code below:

```java
package org.kodejava.example.jpa.dao;

import org.kodejava.example.jpa.entity.Artist;

import java.util.List;

public interface ArtistDao {
    Artist findById(Long id);

    void save(Artist artist);

    void update(Artist artist);

    List<Artist> getArtists();

    void deleteById(Long id);

    void delete(Artist artist);
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

    /**
     * Delete artist by their Id.
     *
     * @param id the artist Id.
     */
    @Override
    public void deleteById(Long id) {
        Artist artist = manager.find(Artist.class, id);
        if (artist != null) {
            manager.getTransaction().begin();
            manager.remove(artist);
            manager.getTransaction().commit();
        }
    }

    /**
     * Delete artist entity.
     *
     * @param artist the object to be deleted.
     */
    @Override
    public void delete(Artist artist) {
        manager.getTransaction().begin();
        manager.remove(artist);
        manager.getTransaction().commit();
    }
}
```

After defining the delete methods in the `ArtistDao` class we create a simple program to demonstrate both of them. In this program we start by create the `EntityManagerFactory` object from the defined persistence unit in the `persistence.xml` file. Then we create the `EntityManager` object and we pass it to our `ArtistDaoImpl` object. And then we call the delete methods to remove entity from the database.

To show you the result of the delete process we print out the artist data before and after the delete method is called.

```java
package org.kodejava.example.jpa;

import org.kodejava.example.jpa.dao.ArtistDao;
import org.kodejava.example.jpa.dao.impl.ArtistDaoImpl;
import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EntityRemoveDemo {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();

        ArtistDao dao = new ArtistDaoImpl(manager);
        System.out.println("Before Delete:");
        printArtists(dao.getArtists());

        // Remove artist with Id = 1.
        dao.deleteById(1L);

        // Remove artist with Id = 2.
        Artist artist = dao.findById(2L);
        dao.delete(artist);

        System.out.println("After Delete:");
        printArtists(dao.getArtists());
    }

    private static void printArtists(List<Artist> artists) {
        for (Artist artist : artists) {
            System.out.println("Artist = " + artist);
        }
    }
}
```

Here is the result of our code snippet. It shows the number of records before and after the delete process.

```
Before Delete:
Artist = Artist{id=1, name='Bon Jovi'}
Artist = Artist{id=2, name='Mr. Big'}
Artist = Artist{id=3, name='Metallica'}
After Delete:
Artist = Artist{id=3, name='Metallica'}
```
