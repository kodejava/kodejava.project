package org.kodejava.example.text;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;

public class CollationKeyExample {
    public static void main(String[] args) {
        String[] countries = {
            "German",
            "United Kingdom",
            "United States",
            "French",
            "Japan",
            "Myanmar",
            "India"
        };

        System.out.println("original:");
        System.out.println(Arrays.toString(countries));

        // Gets Collator object of default locale
        Collator collator = Collator.getInstance();

        // Creates and initializes CollationKey array
        CollationKey[] keys = new CollationKey[countries.length];

        for (int i = 0; i < countries.length; i++) {
            // Generate CollationKey by calling
            // Collator.getCollationKey() method then assign into
            // keys which is an array of CollationKey.
            // The CollationKey for the given String based on the
            // Collator's collation rules.
            keys[i] = collator.getCollationKey(countries[i]);
        }

        // Sort the keys array
        Collections.sort(Arrays.asList(keys));

        // Print out the sorted array
        System.out.println("sorted result: ");
        StringBuilder sb = new StringBuilder("[");
        for (CollationKey key : keys) {
            sb.append(key.getSourceString()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb.toString());
    }
}
