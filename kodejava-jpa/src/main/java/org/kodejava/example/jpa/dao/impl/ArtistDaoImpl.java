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
