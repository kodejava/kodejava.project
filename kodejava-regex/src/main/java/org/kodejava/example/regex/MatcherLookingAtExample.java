package org.kodejava.example.regex;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherLookingAtExample {

    public static void main(String[] args) {
        // Get the available countries
        Set<String> countries = new TreeSet<>();
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            countries.add(locale.getDisplayCountry());
        }

        // Create a Pattern instance. Look for a country that start with
        // "I" with an arbitrary second letter and have either "a" or "e"
        // letter in the next sequence.
        Pattern pattern = Pattern.compile("^I.[ae]");
        System.out.println("Country name which have the pattern of " +
            pattern.pattern() + ": ");

        // Find country name which prefix matches the matcher's pattern
        for (String country : countries) {
            // Create matcher object
            Matcher matcher = pattern.matcher(country);

            // Check if the matcher's prefix match with the matcher's
            // pattern
            if (matcher.lookingAt()) {
                System.out.println("Found: " + country);
            }
        }
    }
}
