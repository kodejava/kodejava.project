package org.kodejava.example.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NegativeNumberFormat {
    // Pattern for formatting negative number.
    public static final String PATTERN1 = "#,##0.00;(#,##0.00)";
    public static final String PATTERN2 = "#,##0.00;-#,##0.00";

    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        //df.applyPattern(PATTERN1);

        // Format using parentheses
        System.out.println("Number: " + nf.format(1250000.25));
        System.out.println("Negative: " + nf.format(-1250000.25));

        // Format using currency symbol and minus sign
        //df.applyPattern(PATTERN2);
        System.out.println("Positive: " + nf.getCurrency().getSymbol() + nf.format(1000));
        System.out.println("Negative: " + nf.getCurrency().getSymbol() + nf.format(-1000));
    }
}
