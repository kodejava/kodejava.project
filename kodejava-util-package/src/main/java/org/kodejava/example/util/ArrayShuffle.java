package org.kodejava.example.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayShuffle {
    public static void main(String[] args) {
        // Initialize the contents of our array
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        // As the Collections.shuffle() method need a list for the parameter
        // we convert our array into List using the Arrays class.
        List<String> list = Arrays.asList(alphabets);

        // Here we just simply used the shuffle method of Collections class
        // to shuffle out defined array.
        Collections.shuffle(list);

        // Run the code again and again, then you'll see how simple we do
        // shuffling
        for (String alpha : list) {
            System.out.print(alpha + " ");
        }
    }
}
