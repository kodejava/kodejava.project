package org.kodejava.example.lang;

public class StringReplace {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog";
        System.out.println("Before: " + text);

        // The replace method replace all occurrences of character
        // 'o' with 'u' and returns a new string object.
        text = text.replace('o', 'u');
        System.out.println("After : " + text);
    }
}
