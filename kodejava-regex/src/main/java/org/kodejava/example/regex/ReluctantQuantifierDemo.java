package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReluctantQuantifierDemo {
    public static void main(String[] args) {
        String[] expressions =
            {"x??", "x*?", "x+?", "x{2}?", "x{2,}?", "x{2,5}?"};
        String input = "xxxxxxx";

        for (String expression : expressions) {
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(input);

            // Find every match and print it
            System.out.println("------------------------------");
            System.out.format("regex:  %s %n", expression);
            while (matcher.find()) {
                System.out.format("Text \"%s\" found at %d to %d%n",
                    matcher.group(), matcher.start(),
                    matcher.end());
            }
        }
    }
}
