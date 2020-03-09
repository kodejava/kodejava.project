package org.kodejava.example.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringReplace {
    public static void main(String[] args) {
        String source = "The quick brown fox jumps over the brown lazy dog.";
        String find = "brown";
        String replace = "red";

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(find);

        // Creates a matcher that will match the given input against the
        // pattern.
        Matcher matcher = pattern.matcher(source);

        // Replaces every subsequence of the input sequence that matches
        // the pattern with the given replacement string.
        String output = matcher.replaceAll(replace);

        System.out.println("Source = " + source);
        System.out.println("Output = " + output);
    }
}
