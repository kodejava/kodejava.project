package org.kodejava.example.util;

import java.util.Calendar;

public class CalendarAddExample {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println("Today : " + cal.getTime());

        // Subtract 30 days from the calendar
        cal.add(Calendar.DATE, -30);
        System.out.println("30 days ago: " + cal.getTime());

        // Add 10 months to the calendar
        cal.add(Calendar.MONTH, 10);
        System.out.println("10 months later: " + cal.getTime());

        // Subtract 1 year from the calendar
        cal.add(Calendar.YEAR, -1);
        System.out.println("1 year ago: " + cal.getTime());
    }
}
