package org.kodejava.example.util;

import java.util.Calendar;

public class DayOfYearToDate {
    public static void main(String[] args) {
        // In the example we want to get the date value of the specified
        // day of the year. Using the calendar object we can define our
        // calendar for a specific day of the year.
        int dayOfYear = 112;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        System.out.println("Day " + dayOfYear + " of the current year = "
            + calendar.getTime());

        // If you want to get the date for a specific day of year and for
        // a specific year, you can also pass the year information to the
        // calendar object.
        int year = 2020;
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        System.out.println("Day " + dayOfYear + " in year " + year
            + " = " + calendar.getTime());
    }
}
