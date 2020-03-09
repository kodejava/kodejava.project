package org.kodejava.example.joda;

import org.joda.time.DateMidnight;
import org.joda.time.LocalDate;
import org.joda.time.Months;

import java.util.Date;

public class MonthsBetweenDemo {
    public static void main(String[] args) {
        // Creates an instance of start and end dates.
        DateMidnight start = new DateMidnight("2019-01-01");
        DateMidnight end = new DateMidnight(new Date());

        // Get months between these dates.
        int months = Months.monthsBetween(start, end).getMonths();

        // Print the result.
        System.out.println("Months between " +
                start.toString("yyyy-MM-dd") + " and " +
                end.toString("yyyy-MM-dd") + " = " +
                months + " month(s)");

        // Using LocalDate object.
        LocalDate date1 = LocalDate.parse("2019-03-01");
        LocalDate date2 = LocalDate.now();
        months = Months.monthsBetween(date1, date2).getMonths();

        // Print the result.
        System.out.println("Months between " +
                date1.toString("yyyy-MM-dd") + " and " +
                date2.toString("yyyy-MM-dd") + " = " +
                months + " month(s)");
    }
}
