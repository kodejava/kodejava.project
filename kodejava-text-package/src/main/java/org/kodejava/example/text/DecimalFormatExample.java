package org.kodejava.example.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DecimalFormatExample {
    public static void main(String[] args) {
        // We have some millions money here that we'll format its look.
        double money = 100550000.75;

        // Creates a formatter
        NumberFormat formatter = new DecimalFormat("#0.00");

        // Print the number using scientific number format and using our
        // defined decimal format pattern above.
        System.out.println(money);
        System.out.println(formatter.format(money));
    }
}
