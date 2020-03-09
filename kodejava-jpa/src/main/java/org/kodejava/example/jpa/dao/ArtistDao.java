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
