package org.kodejava.example.lang;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        Integer[] numbers = {10, 100, 1000, 10000, 100000, 1000000};

        for (Integer i : numbers) {
            System.out.println("Number: " + i);
        }

        List<String> names = new ArrayList<>();
        names.add("James");
        names.add("Joshua");
        names.add("Scott");

        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
}
