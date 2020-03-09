package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

public class ReadNestedProperty {
    public static void main(String[] args) {
        Track track = new Track();
        track.setId(1L);
        track.setTitle("All My Loving");
        track.setArtist(new Artist(1L, "Beatles"));

        try {
            String artistName = (String) PropertyUtils.getNestedProperty(track, "artist.name");
            System.out.println("Artist Name = " + artistName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
