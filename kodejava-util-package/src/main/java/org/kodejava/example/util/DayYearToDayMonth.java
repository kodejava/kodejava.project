package org.kodejava.example.util;

import java.util.Calendar;

public class DayYearToDayMonth {
    public static void main(String[] args) {
        // Create an instance of calendar for the year 2017 and set the
        // day to the 180 day of the year.
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2017);
        cal.set(Calendar.DAY_OF_YEAR, 180);

        // Print the date of the calendar.
        System.out.println("Calendar date is: " + cal.getTime());

        // To know what day in month of the calendar we can obtain the
        // value by calling Calendar's instance get() method and pass
        // the Calendar.DAY_OF_MONTH field.
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        // Print which month day is it in number.
        System.out.println("Calendar day of month: " + dayOfMonth);

        // To know what day in week of the calendar we can obtain the
        // value by calling Calendar's instance get() method and pass
        // the Calendar.DAY_OF_WEEK field.
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // Print which week day is it in number.
        System.out.println("Calendar day of week: " + dayOfWeek);
    }
}
