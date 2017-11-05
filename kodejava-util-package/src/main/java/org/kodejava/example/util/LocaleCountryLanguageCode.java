package org.kodejava.example.util;

import java.util.Locale;

public class LocaleCountryLanguageCode {
    public static void main(String[] args) {
        // Gets an array of all installed locales. The returned array represents
        // the union of locales supported by the Java runtime environment and by
        // installed LocaleServiceProvider implementations.
        Locale[] locales = Locale.getAvailableLocales();

        for (Locale locale : locales) {
            System.out.printf("Locale name: %s = %s_%s%n",
                locale.getDisplayName(), locale.getLanguage(), locale.getCountry());
        }
    }
}
