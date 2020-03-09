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
