package org.kodejava.example.util;

import java.util.*;

public class EnumerationSort {
    public static void main(String[] args) {
        // Creates random data for sorting source. Will use java.util.Vector
        // to store the random integer generated.
        Random random = new Random();
        Vector<Integer> data = new Vector<>();
        for (int i = 0; i < 10; i++) {
            data.add(Math.abs(random.nextInt()));
        }

        // Get the enumeration from the vector object and convert it into
        // a java.util.List. Finally we sort the list using
        // Collections.sort() method.
        Enumeration<Integer> enumeration = data.elements();
        List<Integer> list = Collections.list(enumeration);
        Collections.sort(list);

        // Prints out all generated number after sorted.
        for (Integer number : list) {
            System.out.println("Number = " + number);
        }
    }
}
