package org.kodejava.example.util;

import java.util.ArrayList;

public class ListTrimToSize {
    public static void main(String[] args) {
        // Create an ArrayList with the initial capacity of 100.
        ArrayList<String> list = new ArrayList<>(100);
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        System.out.println("Size: " + list.size());

        // Trim the capacity of the ArrayList to the size
        // of the ArrayList. We can do this operation to reduce
        // the memory use to store data by the ArrayList.
        list.trimToSize();
    }
}
