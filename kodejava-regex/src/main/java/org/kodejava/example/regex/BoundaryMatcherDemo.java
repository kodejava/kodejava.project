package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoundaryMatcherDemo {
    public static void main(String[] args) {
        // Define regex to find the word "dog" at the end of the line.
        String regex = "dog$";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(
            "The quick brown fox jumps over the lazy dog");

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
