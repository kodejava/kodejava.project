package org.kodejava.example.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "records")
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Date releaseDate;
    private Artist artist;
    private Label label;

    private List<Track> trackList = new ArrayList<>();

    public Record() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Artist getArtist() {
        return artist;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Label getLabel() {
        return label;
    }

    @OneToMany(mappedBy = "record")
    public List<Track> getTrackList() {
        return trackList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) &&
            Objects.equals(title, record.title) &&
            Objects.equals(releaseDate, record.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate);
    }

    @Override
    public String toString() {
        return "Record{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            '}';
    }
}
