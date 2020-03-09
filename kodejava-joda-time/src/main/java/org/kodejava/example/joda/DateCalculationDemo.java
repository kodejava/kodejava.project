package org.kodejava.example.joda;

import org.joda.time.LocalDate;

public class DateCalculationDemo {
    public static void main(String[] args) {
        // Creates an instance of LocalDate where we are going to do
        // some date calculations.
        LocalDate date = new LocalDate(2019, 7, 1);
        System.out.println("Date           = " + date);

        // Add days, weeks, months, year value into the date object.
        System.out.println("plusDays(10)   = " + date.plusDays(10));
        System.out.println("plusWeeks(9)   = " + date.plusWeeks(9));
        System.out.println("plusMonths(2)  = " + date.plusMonths(2));
        System.out.println("plusYears(1)   = " + date.plusYears(1));

        // Subtract days, weeks, months, year value from date object.
        System.out.println("minusDays(10)  = " + date.minusDays(10));
        System.out.println("minusWeeks(9)  = " + date.minusWeeks(9));
        System.out.println("minusMonths(2) = " + date.minusMonths(2));
        System.out.println("minusYears(1)  = " + date.minusYears(1));
    }
}
