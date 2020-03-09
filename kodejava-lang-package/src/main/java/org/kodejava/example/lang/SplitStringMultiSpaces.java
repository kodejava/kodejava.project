package org.kodejava.example.lang;

import java.util.Arrays;

public class SplitStringMultiSpaces {
    public static void main(String[] args) {
        String text = "18/08/2017    SHOES      RUNNING RED   99.9 USD";

        // Split the string using the \s+ regex to split multi spaces
        // line of text.
        var items = text.split("\\s+");
        System.out.println("Length = " + items.length);
        System.out.println("Items  = " + Arrays.toString(items));
    }
}
