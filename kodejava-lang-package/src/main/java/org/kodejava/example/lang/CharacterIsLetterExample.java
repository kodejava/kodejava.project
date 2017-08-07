package org.kodejava.example.lang;

public class CharacterIsLetterExample {
    public static void main(String[] args) {
        String name = "Kode Java 123";

        // Determines if the specified character is a letter
        if (Character.isLetter(name.charAt(5))) {
            System.out.println("The fifth character (" +
                name.charAt(5) + ") is an alphabet!");
        }

        // Iterates all characters in the string to see if it is
        // a letter or not.
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                System.out.println(c + " is a letter.");
            } else {
                System.out.println(c + " not a letter.");
            }
        }
    }
}
