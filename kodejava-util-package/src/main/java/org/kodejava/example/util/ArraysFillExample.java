package org.kodejava.example.util;

import java.util.Arrays;

public class ArraysFillExample {
    public static void main(String[] args) {
        // Assign -1 to each elements of numbers array
        int[] numbers = new int[5];
        Arrays.fill(numbers, -1);
        System.out.println("Numbers: " + Arrays.toString(numbers));

        // Assign 1.0f to each elements of prices array
        float[] prices = new float[5];
        Arrays.fill(prices, 1.0f);
        System.out.println("Prices : " + Arrays.toString(prices));

        // Assign empty string to each elements of words array
        String[] words = new String[5];
        Arrays.fill(words, "");
        System.out.println("Words  : " + Arrays.toString(words));

        // Assign 9 to each elements of the multi array
        int[][] multi = new int[3][3];
        for (int[] array : multi) {
            Arrays.fill(array, 9);
        }
        System.out.println("Multi  : " + Arrays.deepToString(multi));
    }
}
