package org.kodejava.example.text;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Collections;
import java.text.Collator;

public class StringShortWithCollator {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Guava");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Apple");

        // Define a collator for US English.
        Collator collator = Collator.getInstance(Locale.US);

        // Sort the list base on the collator
        Collections.sort(fruits, collator);

        for (String fruit : fruits) {
            System.out.println("Fruit = " + fruit);
        }
    }
}
