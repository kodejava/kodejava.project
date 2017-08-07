package org.kodejava.example.lang;

import java.util.Arrays;

public class StringSplit {
    public static void main(String[] args) {
        String data = "1,Diego Maradona,Footballer,Argentina";
        String[] items = data.split(",");

        // Iterates the array to print it out.
        for (String item : items) {
            System.out.println("item = " + item);
        }

        // Or simply use Arrays.toString() when print it out.
        System.out.println("item = " + Arrays.toString(items));
    }
}
