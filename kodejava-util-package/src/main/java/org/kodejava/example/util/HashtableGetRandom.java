package org.kodejava.example.util;

import java.util.Hashtable;
import java.util.Random;

public class HashtableGetRandom {
    public static void main(String[] args) {
        // Create a hashtable and put some key-value pair.
        Hashtable<String, String> colors = new Hashtable<>();
        colors.put("black", "#000");
        colors.put("red", "#f00");
        colors.put("green", "#0f0");
        colors.put("blue", "#00f");
        colors.put("white", "#fff");

        // Get a random entry from the hashtable.
        String[] keys = colors.keySet().toArray(new String[colors.size()]);
        String key = keys[new Random().nextInt(keys.length)];
        System.out.println(key + " = " + colors.get(key));
    }
}
