package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class CheckSameDay {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date();

        // Checks to see if the dates is on the same day.
        if (DateUtils.isSameDay(date1, date2)) {
            System.out.printf("%1$te/%1$tm/%1$tY and %2$te/%2$tm/%2$tY " +
                    "is on the same day.%n", date1, date2);
        }

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        // Checks to see if the calendars is on the same day.
        if (DateUtils.isSameDay(cal1, cal2)) {
            System.out.printf("%1$te/%1$tm/%1$tY and %2$te/%2$tm/%2$tY " +
                    "is on the same day.%n", cal1, cal2);
        }

        cal2.add(Calendar.DAY_OF_MONTH, 10);
        if (!DateUtils.isSameDay(cal1, cal2)) {
            System.out.printf("%1$te/%1$tm/%1$tY and %2$te/%2$tm/%2$tY " +
                    "is not on the same day.", cal1, cal2);
        }
    }
}
