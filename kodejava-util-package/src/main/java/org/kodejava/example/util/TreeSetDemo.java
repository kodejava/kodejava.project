package org.kodejava.example.util;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // The TreeSet class is an implementation of a SortedSet, this means
        // that when your are using the TreeSet to store you data collections
        // you'll get the items ordered base on its elements natural order.
        Set<String> set = new TreeSet<>();

        // In the example below we add some letters to the TreeSet, this mean
        // that the alphabets will be ordered based on the alphabet order
        // which is from A to Z.
        set.add("Z");
        set.add("A");
        set.add("F");
        set.add("B");
        set.add("H");
        set.add("X");
        set.add("N");

        for (String item : set) {
            System.out.print(item + " ");
        }
    }
}
