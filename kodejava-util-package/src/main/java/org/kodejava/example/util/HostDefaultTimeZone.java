package org.kodejava.example.util;

import java.util.TimeZone;

public class HostDefaultTimeZone {
    public static void main(String[] args) {
        // Gets the default TimeZone ID for this host
        String id = TimeZone.getDefault().getID();
        System.out.println("Default Time Zone ID: " + id);
    }
}
