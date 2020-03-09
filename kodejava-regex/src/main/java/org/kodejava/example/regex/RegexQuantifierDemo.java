package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuantifierDemo {
    public static void main(String[] args) {
        String[] expressions =
            {"x?", "x*", "x+", "x{2}", "x{2,}", "x{2,5}"};

        String input = "xxxxxx yyyxxxxxx zzzxxxxxx";

        for (String expression : expressions) {
            // Compiles the given regular expression into a
            // pattern and creates a matcher that will match
            // the given input against this pattern.
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(input);

            // Find every match and print it
            System.out.format("regex:  %s %n", expression);
            while (matcher.find()) {
                System.out.format("Text \"%s\" found at %d to %d%n",
                    matcher.group(), matcher.start(),
                    matcher.end());
            }
            System.out.println("------------------------------");
        }
    }
}
