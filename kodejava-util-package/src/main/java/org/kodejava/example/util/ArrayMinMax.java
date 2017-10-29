package org.kodejava.example.util;

import java.util.Arrays;
import java.util.Collections;

public class ArrayMinMax {
    public static void main(String[] args) {
        // Creates an array of integer numbers in it.
        Integer[] numbers = {8, 2, 6, 7, 0, 1, 4, 9, 5, 3};

        // To get the minimum or maximum value from the array we can
        // use the Collections.min() and Collections.max() methods.
        // But as this method requires a list type of data we need
        // to convert the array to list first.
        int min = Collections.min(Arrays.asList(numbers));
        int max = Collections.max(Arrays.asList(numbers));

        // Viola! we get the minimum and the maximum value from the
        // array.
        System.out.println("Min number: " + min);
        System.out.println("Max number: " + max);
    }
}
