package org.kodejava.example.util;

import java.util.Calendar;

public class LastDateOfMonth {
    public static void main(String[] args) {
        // Get a calendar instance
        Calendar calendar = Calendar.getInstance();

        // Get the last date of the current month. To get the last date for 
        // a specific month you can set the calendar month using calendar 
        // object calendar.set(Calendar.MONTH, theMonth) method.
        int lastDate = calendar.getActualMaximum(Calendar.DATE);

        // Print the current date and the last date of the month
        System.out.println("Date     : " + calendar.getTime());
        System.out.println("Last Date: " + lastDate);
    }
}
