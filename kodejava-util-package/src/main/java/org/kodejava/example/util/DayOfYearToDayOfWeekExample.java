package org.kodejava.example.util;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class DayOfYearToDayOfWeekExample {
    public static void main(String[] args) {
        // Create a calendar with year and day of year.
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.DAY_OF_YEAR, 180);

        // See the full information of the calendar object.
        System.out.println(calendar.getTime().toString());

        // Get the weekday and print it
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("Weekday: " + weekday);

        // Get weekday name
        DateFormatSymbols dfs = new DateFormatSymbols();
        System.out.println("Weekday: " + dfs.getWeekdays()[weekday]);
    }
}
