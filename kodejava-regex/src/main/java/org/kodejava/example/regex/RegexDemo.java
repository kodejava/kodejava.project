package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        /*
         * To create a Pattern instance we must call the static method
         * called compile() in the Pattern class. Pattern object is
         * the compiled representation of a regular expression.
         */
        Pattern pattern = Pattern.compile("lazy");

        /*
         * The Matcher class also doesn't have the public constructor
         * so to create a matcher class the Patter's class matcher()
         * method. The Matcher object it self is the engine that match
         * the input string against the provided pattern.
         */
        String input = "The quick brown fox jumps over the lazy dog";
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
