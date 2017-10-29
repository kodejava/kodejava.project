package org.kodejava.example.util;

import java.util.Arrays;

public class ArraySortExample {
    public static void main(String[] args) {
        // An array of random numbers
        int numbers[] = {3, 1, 8, 34, 1, 2, 13, 89, 5, 21, 55};
        System.out.println("Before: " + Arrays.toString(numbers));

        // We need to sort these array elements into a correct order
        // from the smallest to the greatest. We will use the Arrays
        // class on java.utils package to do the sort. The sort
        // method of this class are overloaded, so they can take
        // other type of array as well such as byte[], long[],
        // float[], Object[].
        Arrays.sort(numbers);
        System.out.println("After : " + Arrays.toString(numbers));

        // We can also do the sort only for the specified range of
        // array elements.
        float money[] = {1.05f, 99.8f, 3f, 4.55f, 7.23f, 6.50f};
        Arrays.sort(money, 3, money.length);

        // Here we display the sort result, the first and the second
        // element of the array is not included in the sort process.
        System.out.println("Money : " + Arrays.toString(money));
    }
}
