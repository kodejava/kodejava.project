package org.kodejava.example.util;

import java.util.Arrays;

public class ArraySearchExample {
    public static void main(String[] args) {
        // We create an array of ints where the search will be done.
        int items[] = {9, 5, 14, 6, 11, 28, 9, 16, 37, 3, 2};

        // The Arrays.binarySearch() require us to sort the array
        // items before we call the method. We can utilize the
        // Arrays.sort() method to do this. If we did not sort the
        // array the result will be undefined, the search process
        // will return a negative result.
        Arrays.sort(items);

        // To search we use Arrays.binarySearch() methods which accept
        // parameters of any array type. To search we passed the array
        // to be searched and the key to be searched for.
        //
        // When the search item exist more than one in the array, this
        // method gives no guarantee which one will be returned.
        int needle = 9;
        int index = Arrays.binarySearch(items, needle);

        // Print out where the 9 number is located in the array.
        System.out.println("Items: " + Arrays.toString(items));
        System.out.println("Item " + needle + " is at index " + index);
    }
}
