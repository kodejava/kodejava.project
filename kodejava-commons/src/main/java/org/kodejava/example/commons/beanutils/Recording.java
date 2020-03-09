package org.kodejava.example.commons.beanutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recording {
    private Long id;
    private String title;
    private List<Track> tracks = new ArrayList<>();
    private Map<String, Track> mapTracks = new HashMap<>();

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

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void setMapTracks(Map<String, Track> mapTracks) {
        this.mapTracks = mapTracks;
    }

    public Map<String, Track> getMapTracks() {
        return mapTracks;
    }
}
