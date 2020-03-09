package org.kodejava.example.joda;

import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class DaysBetweenDemo {
    public static void main(String[] args) {
        // Define the start and end dates. We use the DateMidnight
        // class to make sure that the calculation start from the
        // midnight.
        DateMidnight start = new DateMidnight("2019-07-01");
        DateMidnight end = new DateMidnight("2019-07-22");

        // Get days between the start date and end date.
        int days = Days.daysBetween(start, end).getDays();

        // Print the result.
        System.out.println("Days between " +
                start.toString("yyyy-MM-dd") + " and " +
                end.toString("yyyy-MM-dd") + " = " +
                days + " day(s)");

        // Using LocalDate object.
        LocalDate date1 = LocalDate.parse("2019-07-01");
        LocalDate date2 = LocalDate.now();
        days = Days.daysBetween(date1, date2).getDays();

        // Print the result.
        System.out.println("Days between " +
                date1.toString("yyyy-MM-dd") + " and " +
                date2.toString("yyyy-MM-dd") + " = " +
                days + " day(s)");
    }
}
