package org.kodejava.example.util;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> errors = new HashMap<>();

        // mapping some data in the map
        errors.put("404", "Resource not found");
        errors.put("403", "Access forbidden");
        errors.put("500", "General server error");

        // reading data from the map
        String errorDescription = errors.get("404");
        System.out.println("Error 404: " + errorDescription);

        // Iterating the map by the keys
        for (String key : errors.keySet()) {
            System.out.println("Error " + key + ": " + errors.get(key));
        }
    }
}
