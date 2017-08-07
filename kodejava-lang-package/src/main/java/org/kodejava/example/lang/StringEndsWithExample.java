package org.kodejava.example.lang;

public class StringEndsWithExample {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";

        // well, does the fox jumps over a lazy dog?
        if (str.endsWith("lazy dog")) {
            System.out.println("The dog is a lazy dog");
        } else {
            System.out.println("Good dog!");
        }

        // Ends with empty string.
        if (str.endsWith("")) {
            System.out.println("true");
        }

        // Ends with the same string.
        if (str.endsWith(str)) {
            System.out.println("true");
        }
    }
}
