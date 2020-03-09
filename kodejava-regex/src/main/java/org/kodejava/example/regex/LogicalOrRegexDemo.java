package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicalOrRegexDemo {
    public static void main(String[] args) {
        // Define regex that will search characters 't' or 'T'
        String regex = "(t|T)";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        String input = "The quick brown fox jumps over the lazy dog";
        Matcher matcher = pattern.matcher(input);

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
