package org.kodejava.example.lang;

public class CharacterIsDigitExample {
    public static void main(String[] args) {
        // Manually creates a string with randoms characters.
        String str = "12?ABC4!6def78+HI@0";

        for (int i = 0; i < str.length(); i++) {
            // Determines if the specified character is a digit
            if (Character.isDigit(str.charAt(i))) {
                System.out.println(str.charAt(i) + " is a digit.");
            } else {
                System.out.println(str.charAt(i) + " not a digit.");
            }
        }
    }
}
