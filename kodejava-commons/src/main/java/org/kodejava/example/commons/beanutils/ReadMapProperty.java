package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.HashMap;
import java.util.Map;

public class ReadMapProperty {
    public static void main(String[] args) {
        Recording recording = new Recording();
        recording.setTitle("Please Please Me");

        Track track1 = new Track();
        track1.setTitle("I Saw Her Standing There");

        Track track2 = new Track();
        track2.setTitle("Misery");

        Map<String, Track> tracks = new HashMap<>();
        tracks.put("Track One", track1);
        tracks.put("Track Two", track2);

        recording.setMapTracks(tracks);

        try {
            Track track = (Track) PropertyUtils.getMappedProperty(recording, "mapTracks(Track One)");
            System.out.println("track.getTitle() = " + track.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
