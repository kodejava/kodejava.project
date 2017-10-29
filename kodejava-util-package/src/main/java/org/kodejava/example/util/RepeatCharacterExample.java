package org.kodejava.example.util;

import java.util.Arrays;

public class RepeatCharacterExample {
    public static void main(String[] args) {
        char c = 'x';
        int length = 10;

        // creates char array with 10 elements
        char[] chars = new char[length];

        // fill each element of chars array with 'x'
        Arrays.fill(chars, c);

        // print out the repeated 'x'
        System.out.println(String.valueOf(chars));
    }
}
