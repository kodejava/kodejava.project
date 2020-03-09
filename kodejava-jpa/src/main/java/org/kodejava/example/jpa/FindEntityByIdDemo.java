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
