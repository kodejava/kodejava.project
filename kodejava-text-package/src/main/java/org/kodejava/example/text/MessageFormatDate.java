package org.kodejava.example.text;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.text.MessageFormat;

public class MessageFormatDate {
    public static void main(String[] args) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);

        Date nextWeek = calendar.getTime();

        // We want the message to be is Locale.US
        Locale.setDefault(Locale.US);

        // Format a date, the time value is included
        String message = MessageFormat.format("Today is {0} and next " +
            "week is {1}", today, nextWeek);
        System.out.println(message);

        // Format a date and display only the date portion
        message = MessageFormat.format("Today is {0,date} and next " +
            "week is {1,date}", today, nextWeek);
        System.out.println(message);

        // Format a date using a short format (eg. dd/MM/yyyy)
        message = MessageFormat.format("Today is {0,date,short} and " +
            "next week is {1,date,short}", today, nextWeek);
        System.out.println(message);

        // Format a date using a medium format, it display the month long name,
        // but using a two digit date and year.
        message = MessageFormat.format("Today is {0,date,medium} and " +
            "next week is {1,date,medium}", today, nextWeek);
        System.out.println(message);

        // Format a date using a long format, two digit for date, a long month
        // name and a four digit year.
        message = MessageFormat.format("Today is {0,date,long} and " +
            "next week is {1,date,long}", today, nextWeek);
        System.out.println(message);

        // Format a date using a full format, the same as above plus a full day
        // name.
        message = MessageFormat.format("Today is {0,date,full} and " +
            "next week is {1,date,full}", today, nextWeek);
        System.out.println(message);

        // Format a date using a custom pattern.
        message = MessageFormat.format("Today is {0,date,dd-MM-yyyy} and " +
            "next week is {1,date,dd-MM-yyyy}", today, nextWeek);
        System.out.println(message);
    }
}
