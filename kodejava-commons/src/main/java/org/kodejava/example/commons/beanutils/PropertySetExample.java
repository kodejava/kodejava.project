package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

public class PropertySetExample {
    public static void main(String[] args) {
        Track track = new Track();
        try {
            PropertyUtils.setProperty(track, "id", 10L);
            PropertyUtils.setProperty(track, "title", "Hey Jude");
            PropertyUtils.setProperty(track, "duration", 180);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Track = " + track);
    }
}
