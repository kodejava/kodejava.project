package org.kodejava.example.hibernate.model;

import java.util.Date;
import java.util.Objects;

public class Record {
    private Long id;
    private String title;
    private Date releaseDate;
    private Artist artist;
    private Label label;

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) &&
            Objects.equals(title, record.title) &&
            Objects.equals(releaseDate, record.releaseDate) &&
            Objects.equals(artist, record.artist) &&
            Objects.equals(label, record.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, artist, label);
    }

    @Override
    public String toString() {
        return "Record{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            ", artist=" + artist +
            ", label=" + label +
            '}';
    }
}
