package org.kodejava.example.util;

import java.util.Date;
import java.util.Calendar;

public class DateCompareAfter {
    public static void main(String[] args) {
        // Get current date
        Date today = new Date();

        // Add 1 day from the current date.
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date tomorrow = calendar.getTime();

        // Tests if this date is after the specified date. This method will
        // return true if the value time represented by the tomorrow object
        // is later than today.
        if (tomorrow.after(today)) {
            System.out.println(tomorrow + " is after " + today);
        }
    }
}
