package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppendReplacementExample {
    public static void main(String[] args) {
        // Create a Pattern instance
        Pattern pattern = Pattern.compile("[Pp]en");

        // Create matcher object
        String input = "Please use your Pen to answer the question, " +
                "black pen is preferred.";
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();

        // Find and replace the text that match the pattern
        while (matcher.find()) {
            matcher.appendReplacement(sb, "pencil");
        }

        // This method reads characters from the input sequence, starting
        // at the append position, and appends them to the given string
        // buffer. It is intended to be invoked after one or more
        // invocations of the appendReplacement method in order to copy
        // the remainder of the input sequence.
        matcher.appendTail(sb);

        System.out.println("Input : " + input);
        System.out.println("Output: " + sb.toString());
    }
}
