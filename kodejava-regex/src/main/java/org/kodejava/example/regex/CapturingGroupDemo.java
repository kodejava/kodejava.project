package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapturingGroupDemo {
    public static void main(String[] args) {
        // Define regex to find the word 'the' or 'quick'
        String regex = "(the)|(quick)";
        String text = "the quick brown fox jumps over the lazy dog";

        // Compiles the given regular expression into a pattern and
        // Creates a matcher that will match the given input against
        // this pattern.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
