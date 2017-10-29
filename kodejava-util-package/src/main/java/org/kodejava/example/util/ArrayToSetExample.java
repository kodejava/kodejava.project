package org.kodejava.example.util;

import java.util.*;

public class ArrayToSetExample {
    public static void main(String[] args) {
        Integer[] numbers = {7, 7, 8, 9, 10, 8, 8, 9, 6, 5, 4};

        // To convert an array into a java.util.Set firstly we need to convert the
        // array into a java.util.List using the Arrays.asList() method. With the
        // List object created we can instantiate a new java.util.HashSet and pass
        // the list as the constructor parameter.
        List<Integer> numberList = Arrays.asList(numbers);
        Set<Integer> numberSet = new HashSet<>(numberList);

        // Or we can simply combine the line above into single line.
        Set<Integer> anotherNumberSet = new HashSet<>(Arrays.asList(numbers));

        // Display what we get in the set using iterator.
        for (Iterator<Integer> iterator = numberSet.iterator(); iterator.hasNext(); ) {
            Integer number = iterator.next();
            System.out.print(number + ", ");
        }

        // Display what we get in the set using for-each.
        for (Integer number : anotherNumberSet) {
            System.out.print(number + ", ");
        }
    }
}
