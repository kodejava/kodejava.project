package org.kodejava.example.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CombineWithQuantifier {
    public static void main(String[] args) {
        // [abc]{3} --> apply quantifier in character class.
        // Find 'a' or 'b' or 'c', three times in a row.
        //
        // (abc){3} --> apply quantifier in capturing group.
        // Find 'abc', three times in a row.
        //
        // abc{3} --> apply quantifier in character class.
        // Find character 'c', three times in a row.
        String[] regexs = {"[abc]{3}", "(abc){3}", "abc{3}"};
        String text = "abcabcabcabcaba";

        for (String regex : regexs) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            // Find every match and print it
            System.out.format("Regex:  %s %n", regex);
            while (matcher.find()) {
                System.out.format("Text \"%s\" found at %d to %d.%n",
                    matcher.group(), matcher.start(),
                    matcher.end());
            }
            System.out.println("------------------------------");
        }
    }
}
