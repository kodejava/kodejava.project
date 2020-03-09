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
