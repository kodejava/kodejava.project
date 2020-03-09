package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassesRangeClassDemo {
    public static void main(String[] args) {
        // Defines regex that will search all sequences of string
        // that begin with bat and number which range [3-7]
        String regex = "bat[3-7]";
        String input =
            "bat1, bat2, bat3, bat4, bat5, bat6, bat7, bat8";

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(regex);

        // Creates a matcher that will match the given input
        // against this pattern.
        Matcher matcher = pattern.matcher(input);

        // Find every matches and prints it.
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(),
                matcher.end());
        }
    }
}
