package org.kodejava.example.joda;

import org.joda.time.DateTime;
import org.joda.time.Instant;

public class InstantDemo {
    public static void main(String[] args) {
        // An instant in the datetime continuum specified as
        // a number of milliseconds from 1970-01-01T00:00Z.
        //
        // The declaration below creates 1 seconds instant from
        // 1970.
        Instant instant = new Instant(1000);

        // Get a new copy of instant with 500 duration added.
        instant = instant.plus(500);

        // Get a new copy of instant with 250 duration taken away.
        instant = instant.minus(250);
        System.out.println("Milliseconds = " + instant.getMillis());

        // Creating an instant that represent the current date.
        DateTime dateTime = new DateTime();
        System.out.println("Date Time = " + dateTime);

        // Creating an instant of a specific date and time.
        DateTime independenceDay = new DateTime(2019, 7, 22, 0, 0, 0);
        System.out.println("Independence Day = " + independenceDay);
    }
}
