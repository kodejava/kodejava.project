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
