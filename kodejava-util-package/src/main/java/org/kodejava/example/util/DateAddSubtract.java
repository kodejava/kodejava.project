package org.kodejava.example.util;

import java.util.Calendar;

public class DateAddSubtract {
    public static void main(String[] args) {
        // Gets a calendar using the default time zone and locale. The
        // Calendar returned is based on the current time in the default
        // time zone with the default locale.
        Calendar calendar = Calendar.getInstance();
        System.out.println("Original = " + calendar.getTime());

        // Substract 2 hour from the current time
        calendar.add(Calendar.HOUR, -2);

        // Add 30 minutes to the calendar time
        calendar.add(Calendar.MINUTE, 30);

        // Add 300 seconds to the calendar time
        calendar.add(Calendar.SECOND, 300);
        System.out.println("Updated  = " + calendar.getTime());
    }
}
