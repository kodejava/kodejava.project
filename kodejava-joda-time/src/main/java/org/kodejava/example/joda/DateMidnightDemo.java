package org.kodejava.example.joda;

import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;

public class DateMidnightDemo {
    public static void main(String[] args) {
        // Create DateMidnight object of the current system date.
        DateMidnight date = new DateMidnight();
        System.out.println("date = " + date);

        // Or using the now().
        date = DateMidnight.now();
        System.out.println("date = " + date);

        // Create DateMidnight object by year, month and day.
        date = new DateMidnight(2019, 7, 22);
        System.out.println("date = " + date);

        // Create DateMidnight object from milliseconds.
        date = new DateMidnight(System.currentTimeMillis());
        System.out.println("date = " + date);

        // Parse a date from string.
        date = DateMidnight.parse("2019-07-22");
        System.out.println("date = " + date);

        // Parse a date from string of specified patter.
        date = DateMidnight.parse("22/07/2019", DateTimeFormat.forPattern("dd/MM/yyyy"));
        System.out.println("date = " + date);
    }
}
