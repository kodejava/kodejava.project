package org.kodejava.example.util;

import java.util.List;
import java.util.ArrayList;

public class CollectionToArrayExample {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Kode");
        words.add("Java");
        words.add("-");
        words.add("Learn");
        words.add("Java");
        words.add("by");
        words.add("Examples");

        String[] array = words.toArray(new String[words.size()]);
        for (String word : array) {
            System.out.println(word);
        }
    }
}
