package org.kodejava.example.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayRemoveDuplicate {
    public static void main(String[] args) {
        // A string array with duplicate values.
        String[] data = {"A", "C", "B", "D", "A", "B", "E", "D", "B", "C"};
        System.out.println("Original array         : " + Arrays.toString(data));

        // Convert a string array into java.util.List because we need a list
        // object to create the java.util.Set object.
        List<String> list = Arrays.asList(data);

        // A set is a collection object that cannot have a duplicate values,
        // by converting the array to a set the duplicate value will be removed.
        Set<String> set = new HashSet<>(list);

        // Convert the java.util.Set back to array using the toArray() method of
        // the set object copy the value in the set to the defined array.
        String[] result = set.toArray(new String[set.size()]);
        System.out.println("Array with no duplicate: " + Arrays.toString(result));
    }
}
