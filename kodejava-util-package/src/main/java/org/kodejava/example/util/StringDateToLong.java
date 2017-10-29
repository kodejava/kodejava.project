package org.kodejava.example.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateToLong {
    public static void main(String[] args) {
        // Here we have a string date and we want to covert it to long value
        String today = "13/10/2017";

        // Create a SimpleDateFormat which will be use to convert the string to
        // a date object.
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // The SimpleDateFormat parse the string and return a date object.
            // To get the date in long value just call the getTime method of
            // the Date object.
            Date date = formatter.parse(today);
            long dateInLong = date.getTime();

            System.out.println("Date         = " + date);
            System.out.println("Date in Long = " + dateInLong);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
