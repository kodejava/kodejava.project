package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

public class ReadIndexedProperty {
    public static void main(String[] args) {
        Recording recording = new Recording();
        recording.setId(1L);
        recording.setTitle("With The Beatles");

        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track();
        track1.setTitle("It Won't Be Long");

        Track track2 = new Track();
        track2.setTitle("All I've Got To Do");

        Track track3 = new Track();
        track3.setTitle("All My Loving");

        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);

        recording.setTracks(tracks);

        try {
            Track trackOne = (Track) PropertyUtils.getIndexedProperty(recording, "tracks[0]");
            Track trackThree = (Track) PropertyUtils.getIndexedProperty(recording, "tracks[2]");

            System.out.println("trackOne.getTitle() = " + trackOne.getTitle());
            System.out.println("trackThree.getTitle() = " + trackThree.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
