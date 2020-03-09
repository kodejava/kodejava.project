package org.kodejava.example.joda;

import org.joda.time.DateTime;

public class TimeCalculationDemo {
    public static void main(String[] args) {
        // Creates an instance of current DateTime which represents the
        // current date time.
        DateTime dateTime = new DateTime();
        System.out.println("DateTime            = " + dateTime);

        // Plus some hours, minutes, and seconds to the original DateTime.
        System.out.println("Plus 60 seconds is  = " + dateTime.plusSeconds(60));
        System.out.println("Plus 10 minutes is  = " + dateTime.plusMinutes(10));
        System.out.println("Plus 1 hour is      = " + dateTime.plusHours(1));

        // Minus some hours, minutes, and seconds to the original DateTime.
        System.out.println("Minus 60 seconds is = " + dateTime.minusSeconds(60));
        System.out.println("Minus 10 minutes is = " + dateTime.minusMinutes(10));
        System.out.println("Minus 1 hour is     = " + dateTime.minusHours(1));
    }
}
