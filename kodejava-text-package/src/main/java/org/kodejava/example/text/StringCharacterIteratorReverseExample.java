package org.kodejava.example.text;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class StringCharacterIteratorReverseExample {
    private static final String text = "Jackdaws love my big sphinx of quartz";

    public static void main(String[] args) {
        CharacterIterator it = new StringCharacterIterator(text);

        System.out.println("Before = " + text);
        System.out.print("After  = ");
        // Iterates a string from the last index to the beginning.
        for (char ch = it.last(); ch != CharacterIterator.DONE; ch = it.previous()) {
            System.out.print(ch);
        }
    }
}
