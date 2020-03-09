package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmbeddedFlagDemo {
    public static void main(String[] args) {
        // Define regex which starting with (?i) to enable
        // case-insensitive matching
        String regex = "(?i)the";
        String text = "The quick brown fox jumps over the lazy dog";

        // Obtain the required matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(),
                matcher.end());
        }
    }
}
