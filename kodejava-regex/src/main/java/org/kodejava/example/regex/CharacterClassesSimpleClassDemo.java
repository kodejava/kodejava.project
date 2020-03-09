package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassesSimpleClassDemo {
    public static void main(String[] args) {
        // Creating a simple class type of character classes.
        // The regular expression below will search all sequences
        // of string that begins with 'b', ends with 't' and have
        // a middle letter of 'a' or 'i'.
        String regex = "b[ai]t";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =
            pattern.matcher("I'm a little bit afraid of bats " +
                "but not cats.");

        // Find every matches and prints it.
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
