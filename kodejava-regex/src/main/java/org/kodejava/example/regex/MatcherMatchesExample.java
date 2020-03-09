package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMatchesExample {

    public static void main(String[] args) {
        String[] inputs = {
            "blue sky",
            "blue sea",
            "blue",
            "blue lagoon"
        };

        // Creates an instance of Pattern using the compile method.
        Pattern pattern = Pattern.compile("blue");

        int match = 0;
        for (String s : inputs) {
            // Creates a matcher that will match the given input
            // against this pattern.
            Matcher matcher = pattern.matcher(s);

            // Check if the input match the pattern exactly and
            // increment the match counter.
            if (matcher.matches()) {
                match++;
            }

        }

        System.out.println("Number of input matched: " + match);
    }
}
