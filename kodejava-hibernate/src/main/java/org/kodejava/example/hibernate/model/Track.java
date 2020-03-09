package org.kodejava.example.hibernate.model;

import java.util.Objects;

public class Track {
    private Long id;
    private String title;
    private Integer duration;
    private Artist artist;
    private Genre genre;
    private Record record;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(id, track.id) &&
            Objects.equals(title, track.title) &&
            Objects.equals(duration, track.duration) &&
            Objects.equals(artist, track.artist) &&
            Objects.equals(genre, track.genre) &&
            Objects.equals(record, track.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration, artist, genre, record);
    }

    @Override
    public String toString() {
        return "Track{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", duration=" + duration +
            ", artist=" + artist +
            ", genre=" + genre +
            ", record=" + record +
            '}';
    }
}
