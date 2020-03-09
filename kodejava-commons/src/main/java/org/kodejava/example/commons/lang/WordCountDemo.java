package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.StringUtils;

public class WordCountDemo {
    public static void main(String[] args) {
        // We have the source text we'll do the search on.
        String source = "From the download page, you can download the Java " +
            "Tutorials for browsing offline. Or you can just download " +
            "the example.";
        // The word we want to count its occurrences
        String word = "you";

        // Using StringUtils.countMatches() method we can count the occurrences
        // frequency of a word/letter in the giver source of string.
        int wordFound = StringUtils.countMatches(source, word);

        // Print how many we have found the word
        System.out.println(wordFound + " occurrences of the word '" + word +
            "' was found in the text.");
    }
}
