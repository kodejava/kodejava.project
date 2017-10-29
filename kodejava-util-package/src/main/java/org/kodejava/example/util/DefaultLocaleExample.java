package org.kodejava.example.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class DefaultLocaleExample {
    public static void main(String[] args) {
        // Use Random class to generate some random number
        Random random = new Random();

        // We use the system default locale to format a number and a date.
        NumberFormat formatter = new DecimalFormat();
        Locale locale = Locale.getDefault();
        System.out.println("Default Locale = " + locale);
        System.out.println("Number         = " + formatter.format(random.nextDouble()));
        System.out.println("Date           = " + new SimpleDateFormat().format(new Date()));

        // We change the default locale to Locale.ITALY by setting it through
        // the Locale.setDefault() method and then we format another number
        // and date using a new locale. This change will affect all the class
        // that aware to the Locale, such as the NumberFormat class.
        Locale.setDefault(Locale.ITALY);
        NumberFormat newFormatter = new DecimalFormat();
        System.out.println("New Locale     = " + Locale.getDefault());
        System.out.println("Number         = " + newFormatter.format(random.nextDouble()));
        System.out.println("Date           = " + new SimpleDateFormat().format(new Date()));
    }
}
