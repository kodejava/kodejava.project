package org.kodejava.example.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Locale;

public class FormattingDemo {
    // Define the date format pattern.
    private static final String pattern = "E MM/dd/yyyy HH:mm:ss.SSS";

    public static void main(String[] args) {
        // Creates a new instance of DateTime object.
        DateTime dt = DateTime.now();

        // Print out the date as a formatted string using the defined
        // Locale information.
        System.out.println("Pattern  = " + pattern);
        System.out.println("Default  = " + dt.toString(pattern));
        System.out.println("Germany  = " + dt.toString(pattern, Locale.GERMANY));
        System.out.println("French   = " + dt.toString(pattern, Locale.FRENCH));
        System.out.println("Japanese = " + dt.toString(pattern, Locale.JAPANESE));

        // Using predefined format from DateTimeFormat class.
        System.out.println("fullDate   = " + dt.toString(DateTimeFormat.fullDate()));
        System.out.println("longDate   = " + dt.toString(DateTimeFormat.longDate()));
        System.out.println("mediumDate = " + dt.toString(DateTimeFormat.mediumDate()));
        System.out.println("shortDate  = " + dt.toString(DateTimeFormat.shortDate()));
        System.out.println("dd/MM/yyyy = " + dt.toString(DateTimeFormat.forPattern("dd/MM/yyyy")));
    }
}
