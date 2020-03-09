package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassUnionDemo {
    public static void main(String[] args) {
        // Defines regex that matches the number 1, 2, 3, 5, 6, 7
        String regex = "[1-3[5-7]]";
        String input = "1234567890";

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Find matches and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(),
                matcher.end());
        }
    }
}
