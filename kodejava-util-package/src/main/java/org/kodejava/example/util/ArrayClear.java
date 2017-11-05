package org.kodejava.example.util;

import java.util.Arrays;

public class ArrayClear {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Carol"};
        System.out.println("Names = " + Arrays.toString(names));

        // Replace the contents of the names array to null for each array
        // element.
        Arrays.fill(names, null);
        System.out.println("Names = " + Arrays.toString(names));

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Numbers = " + Arrays.toString(numbers));

        // Replace the contents of the numbers array to null for each
        // array element.
        Arrays.fill(numbers, null);
        System.out.println("Numbers = " + Arrays.toString(numbers));
    }
}
