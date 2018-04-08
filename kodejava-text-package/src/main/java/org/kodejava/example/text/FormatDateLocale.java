package org.kodejava.example.text;

import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FormatDateLocale {
    public static void main(String[] args) {
        // Defines an array of Locale we are going to use for
        // formatting date information.
        Locale[] locales = new Locale[] {
            Locale.JAPAN,
            Locale.CHINA,
            Locale.KOREA,
            Locale.TAIWAN,
            Locale.ITALY,
            Locale.FRANCE,
            Locale.GERMAN
        };

        // Get an instance of current date time
        Date today = new Date();

        // Iterates the entire Locale defined above and create a long
        // formatted date using the SimpleDateFormat.getDateInstance()
        // with the format, the Locale and the date information.
        for (Locale locale : locales) {
            System.out.printf("Date format in %s = %s%n",
                locale.getDisplayName(), SimpleDateFormat.getDateInstance(
                    SimpleDateFormat.LONG, locale).format(today));
        }
    }
}
