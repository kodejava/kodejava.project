package org.kodejava.example.text;

import java.text.DateFormat;
import java.util.Date;

public class DefaultDateFormatExample {
    public static void main(String[] args) {
        Date date = new Date();

        // Format date in a short format
        String today = DateFormat.getDateTimeInstance(DateFormat.SHORT,
            DateFormat.SHORT).format(date);
        System.out.println("Today " + today);

        // Format date in a medium format
        today = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
            DateFormat.MEDIUM).format(date);
        System.out.println("Today " + today);

        // Format date in a long format
        today = DateFormat.getDateTimeInstance(DateFormat.LONG,
            DateFormat.LONG).format(date);
        System.out.println("Today " + today);
    }
}
