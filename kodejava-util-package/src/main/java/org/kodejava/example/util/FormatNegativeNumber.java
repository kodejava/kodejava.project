package org.kodejava.example.util;

import java.util.Formatter;
import java.util.Locale;

public class FormatNegativeNumber {
    public static void main(String[] args) {
        // Creates an instance of Formatter, format the number using the
        // format and print out the result.
        Formatter formatter = new Formatter();
        formatter.format("%(,.2f", -199.99f);
        System.out.println("number1 = " + formatter);

        // Use String.format() method instead of creating an instance of
        // Formatter. Format a negative number using Germany locale.
        String number2 = String.format(Locale.GERMANY, "%(,8.2f", -49.99);
        System.out.println("number2 = " + number2);

        // Format number using Indonesian locale. The thousand separator is "."
        // in Indonesian number.
        String number3 = String.format(new Locale("id", "ID"), "%(,d", -10000);
        System.out.println("number3 = " + number3);
    }
}
