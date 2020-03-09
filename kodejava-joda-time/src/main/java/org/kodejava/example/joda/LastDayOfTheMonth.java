package org.kodejava.example.joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class LastDayOfTheMonth {
    public static void main(String[] args) {
        // Creates an instance of DateTime.
        DateTime dateTime = DateTime.now();

        // Get the last date of the month using the dayOfMonth property
        // and get the maximum value from it.
        DateTime lastDate = dateTime.dayOfMonth().withMaximumValue();

        // Print the date and day name.
        System.out.println("Date = " + lastDate.toString());
        System.out.println("Day  = " + lastDate.dayOfWeek().getAsText());

        // If you know the last date of the month you can simply parse the
        // date string and get the name of the last day of the month.
        String day = LocalDate.parse("2019-07-31").dayOfWeek().getAsText();
        System.out.println("Day  = " + day);
    }
}
