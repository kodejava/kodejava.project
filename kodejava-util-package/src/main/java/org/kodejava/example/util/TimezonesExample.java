package org.kodejava.example.util;

import java.util.TimeZone;

public class TimezonesExample {
    public static void main(String[] args) {
        String[] availableTimezones = TimeZone.getAvailableIDs();

        for (String timezone : availableTimezones) {
            System.out.println("Timezone ID = " + timezone);
        }
    }
}
