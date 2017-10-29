package org.kodejava.example.util;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample {
    public static void main(String[] args) {
        String[] words = {"Happy", "New", "Year", "2017"};
        List<String> list = Arrays.asList(words);

        for (String word : list) {
            System.out.println(word);
        }
    }
}
