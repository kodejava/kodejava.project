package org.kodejava.example.util;

import java.util.SortedSet;
import java.util.TreeSet;

public class LastSetElement {
    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");

        // SortedSet orders the items it contains. After that we get the last
        // item from the set using last() method. The last item will be "Two".
        String lastElement = set.last();
        System.out.println("lastElement = " + lastElement);
    }
}
