package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PossessiveQuantifierDemo {
    public static void main(String[] args) {
        String[] regexs = {
            "x?+",
            "x*+",
            "x++",
            "x{2}+",
            "x{2,}+",
            "x{2,5}+"
        };
        String input = "xxxxxxx";

        for (String r : regexs) {
            Pattern pattern = Pattern.compile(r);
            Matcher matcher = pattern.matcher(input);

            // Find every match and print it
            System.out.format("Regex:  %s%n", r);
            while (matcher.find()) {
                System.out.format("Text \"%s\" found at %d to %d.%n",
                    matcher.group(), matcher.start(),
                    matcher.end());
            }
            System.out.println("------------------------------");
        }
    }
}
