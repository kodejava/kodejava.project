package org.kodejava.example.util;

import java.util.Calendar;

public class DaysBetweenDate {
    public static void main(String[] args) {
        // Month value in Java is 0-based so 11 means December.
        Calendar start = Calendar.getInstance();
        start.set(2017, 11, 1);
        Calendar end = Calendar.getInstance();
        end.set(2017, 11, 31);

        System.out.print("Number Monday between " +
            start.getTime() + " and " + end.getTime() + " are: ");

        int numberOfDays = 0;
        int monday = Calendar.MONDAY;

        while (start.before(end)) {
            if (start.get(Calendar.DAY_OF_WEEK) == monday) {
                numberOfDays++;
                start.add(Calendar.DATE, 7);
            } else {
                start.add(Calendar.DATE, 1);
            }
        }

        System.out.println(numberOfDays);
    }
}
