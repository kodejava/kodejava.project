package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsToString {
    public static void main(String[] args) {
        // Print int array as string.
        int[] numbers = {1, 2, 3, 5, 8, 13, 21, 34};
        System.out.println("Numbers = " + ArrayUtils.toString(numbers));

        // Print string array as string.
        String[] grades = {"A", "B", "C", "D", "E", "F"};
        System.out.println("Grades = " + ArrayUtils.toString(grades));

        // Print multidimensional array as string.
        int[][] matrix = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}};
        System.out.println("Matrix = " + ArrayUtils.toString(matrix));

        // Return "Empty" when the array is null.
        String[] colors = null;
        System.out.println("Colors = " + ArrayUtils.toString(colors, "None"));
    }
}
