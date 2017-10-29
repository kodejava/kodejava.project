package org.kodejava.example.util;

import java.util.*;

public class SetToArray {
    public static void main(String[] args) {
        // Create a java.util.Set object and add some integers into the Set.
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
        numberSet.add(5);
        numberSet.add(8);

        // Converting a java.util.Set into an array can be done by creating a
        // java.util.List object from the Set and then convert it into an array
        // by calling the toArray() method on the list object.
        List<Integer> numberList = new ArrayList<>(numberSet);
        Integer[] numbers = numberList.toArray(new Integer[numberList.size()]);

        // Display the content of numbers array.
        for (int i = 0; i < numbers.length; i++) {
            Integer number = numbers[i];
            System.out.print(number + (i < numbers.length - 1 ? ", " : "\n"));
        }

        // Display the content of numbers array using the for-each loop.
        for (Integer number : numbers) {
            System.out.print(number + ", ");
        }
    }
}
