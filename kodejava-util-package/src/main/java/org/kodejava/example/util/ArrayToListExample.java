package org.kodejava.example.util;

import java.util.Arrays;
import java.util.List;

public class ArrayToListExample {
    public static void main(String[] args) {
        // Creates an array of object, in this case we create an
        // Integer array.
        Integer[] numbers = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

        // Convert the created array above to collection, in this
        // example we convert it to a List.
        List<Integer> list = Arrays.asList(numbers);

        // We've got a list of our array here and iterate it.
        for (Integer number : list) {
            System.out.print(number + ", ");
        }
    }
}
