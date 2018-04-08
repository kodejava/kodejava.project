package org.kodejava.example.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatterPattern {
    public static void main(String[] args) {
        String[] patterns = {"###,###,###.##", "000000000.00", "$###,###.##"};

        double before = 1234567.899;

        // To obtain a NumberFormat for a specific locale,
        // including the default locale, call one of NumberFormat's
        // factory methods, such as getNumberInstance(). Then cast
        // it into a DecimalFormat.
        DecimalFormat format = (DecimalFormat) NumberFormat.getNumberInstance(Locale.UK);
        for (String pattern : patterns) {
            // Apply the given pattern to this Format object
            format.applyPattern(pattern);

            // Gets the formatted value
            String after = format.format(before);

            System.out.printf("Input: %s, Pattern: %s, Output: %s%n", before, pattern, after);
        }
    }
}
