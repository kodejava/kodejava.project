package org.kodejava.example.commons.lang;

import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

public class ArrayToMapExample {

    public static void main(String[] args) {
        // A two dimensional array of countries capital.
        String[][] countries = {{"United States", "Washington, D.C."},
            {"United Kingdom", "London"},
            {"Netherlands", "Amsterdam"},
            {"Japan", "Tokyo"},
            {"France", "Paris"}};

        // Convert an array to a Map.
        Map capitals = ArrayUtils.toMap(countries);

        for (Object key : capitals.keySet()) {
            System.out.printf("%s is the capital of %s.%n", capitals.get(key), key);
        }
    }
}
