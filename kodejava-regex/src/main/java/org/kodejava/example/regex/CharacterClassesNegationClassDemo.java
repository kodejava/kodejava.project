package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassesNegationClassDemo {
    public static void main(String[] args) {
        // Defines a regular expression that will search all
        // sequences of string that begin with 'h' and end with 't'
        // and have a middle letter except those appearing to the
        // right of the ^ character within the square brackets
        // ('a' and 'o')
        String regex = "h[^ao]t";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =
            pattern.matcher("Wow, that hot hat will make a hit");

        // Find every matches and prints it.
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
