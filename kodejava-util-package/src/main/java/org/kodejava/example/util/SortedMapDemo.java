package org.kodejava.example.util;

import java.util.*;

public class SortedMapDemo {
    public static void main(String[] args) {
        SortedMap<String, String> sorted = new TreeMap<>();
        sorted.put("United States", "New York");
        sorted.put("United Kingdom", "London");
        sorted.put("Netherlands", "Amsterdam");
        sorted.put("Japan", "Tokyo");
        sorted.put("France", "Paris");

        // Gets the first(lowest) key currently in this map
        String firstKey = sorted.firstKey();

        // Gets the last (highest) key currently in this map
        String lastKey = sorted.lastKey();

        System.out.println("First key: " + firstKey);
        System.out.println("Last key : " + lastKey);

        // Gets a view of the portion of this map whose keys range
        // from fromKey(Japan), inclusive, to toKey(United Kingdom),
        // exclusive. (If fromKey and toKey are equal, the returned
        // map is empty.)
        SortedMap<String, String> sub = sorted.subMap("Japan",
            "United Kingdom");
        Set<String> subKeys = sub.keySet();
        System.out.println("\nSub Map: ");
        System.out.println("============");
        for (String key : subKeys) {
            System.out.println(key);
        }

        // Gets a view of the portion of this map whose keys are
        // strictly less than toKey(in this example is Netherlands)
        SortedMap<String, String> head = sorted.headMap("Netherlands");
        Set<String> headKeys = head.keySet();
        System.out.println("\nHead Map:");
        System.out.println("============");
        for (String key : headKeys) {
            System.out.println(key);
        }

        // Gets a view of the portion of this map whose keys are
        // strictly greater than or equal fromKey(in this example
        // is Netherlands)
        SortedMap<String, String> tail = sorted.tailMap("Netherlands");
        Set<String> tailKeys = tail.keySet();
        System.out.println("\nTail Map:");
        System.out.println("============");
        for (String key : tailKeys) {
            System.out.println(key);
        }
    }
}
