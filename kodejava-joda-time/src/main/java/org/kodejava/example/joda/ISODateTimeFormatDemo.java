package org.kodejava.example.joda;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

public class ISODateTimeFormatDemo {
    public static void main(String[] args) {
        DateTime dateTime = DateTime.now();

        // Returns a basic formatter for a full date as four digit
        // year, two digit month of year, and two digit day of
        // month yyyyMMdd.
        System.out.println(dateTime.toString(
                ISODateTimeFormat.basicDate()));
        System.out.println(dateTime.toString(
                ISODateTimeFormat.basicDateTime()));
        System.out.println(dateTime.toString(
                ISODateTimeFormat.basicDateTimeNoMillis()));

        // Returns a formatter for a full ordinal date, using a four
        // digit year and three digit dayOfYear yyyyDDD.
        System.out.println(dateTime.toString(
                ISODateTimeFormat.basicOrdinalDate()));

        // Returns a basic formatter for a full date as four digit
        // weekyear, two digit week of weekyear, and one digit day
        // of week xxxx'W'wwe
        System.out.println(dateTime.toString(
                ISODateTimeFormat.basicWeekDate()));
        System.out.println(dateTime.toString(
                ISODateTimeFormat.basicWeekDateTime()));
    }
}
