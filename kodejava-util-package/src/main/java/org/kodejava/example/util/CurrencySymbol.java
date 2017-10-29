package org.kodejava.example.util;

import java.util.Currency;
import java.util.Locale;

public class CurrencySymbol {
    public static void main(String[] args) {
        Currency currency = Currency.getInstance(Locale.JAPAN);
        System.out.println("Japan = " + currency.getSymbol());

        currency = Currency.getInstance(Locale.UK);
        System.out.println("UK = " + currency.getSymbol());

        currency = Currency.getInstance(Locale.US);
        System.out.println("US = " + currency.getSymbol());

        currency = Currency.getInstance(new Locale("in", "ID"));
        System.out.println("Indonesia = " + currency.getSymbol());
    }
}
