package org.kodejava.example.util;

import java.util.TimeZone;

public class TimeZoneByOffset {
    public static void main(String[] args) {
        // Gets the available IDs according to the given time zone
        // offset in milliseconds.
        int offset = 8 * 60 * 60 * 1000;
        String[] timezones = TimeZone.getAvailableIDs(offset);

        System.out.println("List of available IDs for GMT:+08:00");
        System.out.println("====================================");
        for (String id : timezones) {
            System.out.println(id);
        }
    }
}
