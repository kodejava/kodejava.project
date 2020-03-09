package org.kodejava.example.regex;

import java.util.regex.Pattern;

public class RegexSplitExample {
    public static void main(String[] args) {
        // Pattern for finding commas, whitespaces (space, tabs, new line,
        // carriage return, form feed).
        String pattern = "[,\\s]+";
        String colours = "Red,White, Blue   Green        Yellow, Orange";

        Pattern splitter = Pattern.compile(pattern);
        String[] result = splitter.split(colours);

        for (String colour : result) {
            System.out.format("Colour = \"%s\"%n", colour);
        }
    }
}
