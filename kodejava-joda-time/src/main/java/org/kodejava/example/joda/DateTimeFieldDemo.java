package org.kodejava.example.joda;

import org.joda.time.DateTime;

public class DateTimeFieldDemo {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.out.println("dateTime = " + dateTime);

        // Get day of year, day of month, day of week and week of
        // year of a date.
        System.out.println("DOY = " + dateTime.getDayOfYear());
        System.out.println("DOM = " + dateTime.getDayOfMonth());
        System.out.println("DOW = " + dateTime.getDayOfWeek());
        System.out.println("WOW = " + dateTime.getWeekOfWeekyear());

        // Get hour of day, minute of hour and second of minute.
        System.out.println("HOD = " + dateTime.getHourOfDay());
        System.out.println("MOH = " + dateTime.getMinuteOfHour());
        System.out.println("SOM = " + dateTime.getSecondOfMinute());

        // Get minute of day and second of day.
        System.out.println("MOD = " + dateTime.getMinuteOfDay());
        System.out.println("SOD = " + dateTime.getSecondOfDay());
    }
}
