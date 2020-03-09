package org.kodejava.example.joda;

import org.joda.time.MutableDateTime;

public class FirstDayOfNextMonth {
    public static void main(String[] args) {
        // Creates an instance of MutableDateTime for the current
        // system date time.
        MutableDateTime dateTime = new MutableDateTime();
        System.out.println("Current date            = " + dateTime);

        // Find the first day of the next month can be done by:
        // 1. Add 1 month to the date
        // 2. Set the day of the month to 1
        // 3. Set the millis of day to 0.
        dateTime.addMonths(1);
        dateTime.setDayOfMonth(1);
        dateTime.setMillisOfDay(0);
        System.out.println("First day of next month = " + dateTime);
    }
}
