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
