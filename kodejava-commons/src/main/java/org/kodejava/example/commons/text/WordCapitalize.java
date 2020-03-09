package org.kodejava.example.commons.text;

import org.apache.commons.text.WordUtils;

public class WordCapitalize {
    public static void main(String[] args) {
        // Capitalizes all the whitespace separated words in a string,
        // only the first letter of each word is capitalized.
        String str = WordUtils.capitalize(
                "The quick brown fox JUMPS OVER the lazy dog.");
        System.out.println("str = " + str);

        // Capitalizes all the whitespace separated words in a string
        // and the rest string to lowercase.
        str = WordUtils.capitalizeFully(
                "The quick brown fox JUMPS OVER the lazy dog.");
        System.out.println("str = " + str);
    }
}
