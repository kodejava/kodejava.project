package org.kodejava.example.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Add items into ArrayList
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        // Remove the third item from ArrayList, first index = 0
        list.remove(2);

        // Iterate ArrayList item using for loop statement
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            System.out.println("Item = " + item);
        }

        // Iterate ArrayList item using for-each statement
        for (String item : list) {
            System.out.println("Item = " + item);
        }

        // Convert ArrayList into array of object
        String[] array = list.toArray(new String[list.size()]);
        System.out.println("Items = " + Arrays.toString(array));
    }
}
