package org.kodejava.example.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

public class DateTimeDemo {

    public static void main(String[] args) {
        // Creates DateTime object using the default constructor will
        // give you the current system date.
        DateTime date = new DateTime();
        System.out.println("date = " + date);

        // Or simply calling the now() method.
        date = DateTime.now();
        System.out.println("date = " + date);

        // Creates DateTime object with information like year, month,
        // day, hour, minute, second and milliseconds
        date = new DateTime(2019, 7, 22, 0, 0, 0, 0);
        System.out.println("date = " + date);

        // Create DateTime object from milliseconds.
        date = new DateTime(System.currentTimeMillis());
        System.out.println("date = " + date);

        // Create DateTime object from Date object.
        date = new DateTime(new Date());
        System.out.println("date = " + date);

        // Create DateTime object from Calendar object.
        Calendar calendar = Calendar.getInstance();
        date = new DateTime(calendar);
        System.out.println("date = " + date);

        // Create DateTime object from string. The format of the
        // string  should be precise.
        date = new DateTime("2019-07-22T13:14:00.000+08:00");
        System.out.println("date = " + date);
        date = DateTime.parse("2019-07-22");
        System.out.println("date = " + date);
        date = DateTime.parse("22/07/2019", DateTimeFormat.forPattern("dd/MM/yyyy"));
        System.out.println("date = " + date);
    }
}
