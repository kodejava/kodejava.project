package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.HashMap;
import java.util.Map;

public class PropertySetMappedExample {

    public static void main(String[] args) {
        // Create an instance of Recording bean.
        Recording recording = new Recording();
        recording.setId(1L);
        recording.setTitle("Introduction");

        // Create a map to hold recording tracks.
        Map<String, Track> tracks = new HashMap<>();
        tracks.put("track-one", new Track());
        tracks.put("track-two", new Track());
        tracks.put("track-three", new Track());
        recording.setMapTracks(tracks);

        try {
            // We add another tracks to the recording track using
            // a PropertyUtils.setMappedProperty() method.
            PropertyUtils.setMappedProperty(recording, "mapTracks", "track-four", new Track());
            PropertyUtils.setMappedProperty(recording, "mapTracks", "track-five", new Track());
        } catch (Exception e) {
            e.printStackTrace();
        }

        tracks = recording.getMapTracks();
        System.out.println("New Track Numbers: " + tracks.size());
        for (String key : tracks.keySet()) {
            System.out.println(key + " = " + tracks.get(key));
        }
    }
}
