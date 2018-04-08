package org.kodejava.example.text;

import java.util.Locale;
import java.text.NumberFormat;

public class LocaleNumberFormat {
    public static void main(String[] args)  {
        // Format number for Italy locale. In Italy locale the decimal point
        // symbol is a comma.
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.ITALY);
        try {
            String number = formatter.format(195325.75);
            System.out.println("Number in Italy: " + number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Format number for Japan locale. In Japan locale the decimal point
        // symbol is a dot.
        formatter = NumberFormat.getNumberInstance(Locale.JAPAN);
        try {
            String number = formatter.format(195325.75);
            System.out.println("Number in Japan: " + number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
