package org.kodejava.example.joda;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeToDateCalendarDemo {
    public static void main(String[] args) {
        // Converting DateTime object into JDK's Date.
        DateTime dateTime = DateTime.now();
        Date date = dateTime.toDate();
        System.out.println("dateTime = " + dateTime);
        System.out.println("date     = " + date);

        // Converting DateTime object into JDK's Calendar.
        Calendar calendar = dateTime.toCalendar(Locale.getDefault());
        System.out.println("calendar = " + calendar);
    }
}
