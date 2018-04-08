package org.kodejava.example.text;

import java.text.NumberFormat;
import java.util.Locale;

public class LocalePercentageFormat {
    public static void main(String[] args) {
        // Format percentage for Locale.US locale with this formatter,
        // a decimal fraction such as 0.75 is displayed as 75%
        double number = 0.25;
        NumberFormat format = NumberFormat.getPercentInstance(Locale.US);
        String percentage = format.format(number);
        System.out.println(number + " in percentage = " + percentage);
    }
}
