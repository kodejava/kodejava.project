package org.kodejava.example.text;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.Collections;

public class RuleBasedCollatorDemo {
    public static void main(String[] args) {
        String rule1 = ("< a < b < c");
        String rule2 = ("< c < b < a");
        String rule3 = ("< c < a < b");

        String words[] = {"apple", "banana", "carrot", "apricot", "blueberry", "cabbage"};

        try {
            RuleBasedCollator rb1 = new RuleBasedCollator(rule1);
            RuleBasedCollator rb2 = new RuleBasedCollator(rule2);
            RuleBasedCollator rb3 = new RuleBasedCollator(rule3);

            System.out.println("original: ");
            System.out.println(Arrays.toString(words));

            // Sort based on rule1
            Collections.sort(Arrays.asList(words), rb1);
            System.out.println("rule: " + rb1.getRules());
            System.out.println(Arrays.toString(words));

            // Sort based on rule2
            Collections.sort(Arrays.asList(words), rb2);
            System.out.println("rule: " + rb2.getRules());
            System.out.println(Arrays.toString(words));

            // Sort based on rule3
            Collections.sort(Arrays.asList(words), rb3);
            System.out.println("rule: " + rb3.getRules());
            System.out.println(Arrays.toString(words));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
