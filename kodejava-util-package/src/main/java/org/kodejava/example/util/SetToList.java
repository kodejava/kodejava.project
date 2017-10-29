package org.kodejava.example.util;

import java.util.*;

public class SetToList {
    public static void main(String[] args) {
        // Create a Set and add some objects into the Set.
        Set<Object> set = new HashSet<>();
        set.add("A");
        set.add(10L);
        set.add(new Date());

        // Convert the Set to a List can be done by passing the Set instance into
        // the constructor of a List implementation class such as ArrayList.
        List<Object> list = new ArrayList<>(set);
        for (Object o : list) {
            System.out.println("Object = " + o);
        }
    }
}
