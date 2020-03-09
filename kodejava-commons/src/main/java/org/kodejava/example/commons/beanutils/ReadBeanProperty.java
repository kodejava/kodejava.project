package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

public class ReadBeanProperty {
    public static void main(String[] args) {
        Track track = new Track();
        track.setTitle("Till There Was You");

        try {
            String title = (String) PropertyUtils.getSimpleProperty(track, "title");
            System.out.println("Track title = " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
