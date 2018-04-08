package org.kodejava.example.text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        Date date = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
        System.out.println("Today : " + today);

        // Display date with day name in a short format
        formatter = new SimpleDateFormat("EEE, dd/MM/yyyy");
        today = formatter.format(date);
        System.out.println("Today : " + today);

        // Display date with a short day and month name
        formatter = new SimpleDateFormat("EEE, dd MMM yyyy");
        today = formatter.format(date);
        System.out.println("Today : " + today);

        // Formatting date with full day and month name and show time up to
        // milliseconds with AM/PM
        formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
        today = formatter.format(date);
        System.out.println("Today : " + today);
    }
}
