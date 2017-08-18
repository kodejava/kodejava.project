package org.kodejava.example.lang;

public class CharAtExample {
    public static void main(String[] args) {
        String[] colors = {"black", "white", "brown", "green", "yellow", "blue"};

        for (String color : colors) {
            // Get char value of a string at index number 3. Because
            // the index is zero based we'll get the fourth character
            // of each color in the array.
            char value = color.charAt(3);
            System.out.printf("The fourth char of %s is '%s'.%n", color, value);
        }

    }
}
