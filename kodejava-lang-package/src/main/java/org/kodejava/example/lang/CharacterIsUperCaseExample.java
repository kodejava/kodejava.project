package org.kodejava.example.lang;

public class CharacterIsUperCaseExample {
    public static void main(String[] args) {
        char a = 'A';

        // Checks to see if a letter is a uppercase letter.
        if (Character.isUpperCase(a)) {
            System.out.println(a + " is an uppercase character.");
        }

        // Checks to see if a letter is an uppercase letter
        // by comparing the character type against
        // Character.UPPERCASE_LETTER constant value.
        int charType = Character.getType(a);
        if (charType == Character.UPPERCASE_LETTER) {
            System.out.println(a + " is an uppercase character.");
        }
    }
}
