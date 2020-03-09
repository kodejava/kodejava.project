package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsIndexOfDemo {
    public static void main(String[] args) {
        String[] colours = { "Red", "Orange", "Yellow", "Green",
            "Blue", "Violet", "Orange", "Blue" };

        // Does colours array contains the Blue colour?
        boolean contains = ArrayUtils.contains(colours, "Blue");
        System.out.println("Contains Blue? " + contains);

        // Can you tell me the index of each colour defined bellow?
        int indexOfYellow = ArrayUtils.indexOf(colours, "Yellow");
        System.out.println("indexOfYellow = " + indexOfYellow);

        int indexOfOrange = ArrayUtils.indexOf(colours, "Orange");
        System.out.println("indexOfOrange = " + indexOfOrange);

        int lastIndexOfOrange = ArrayUtils.lastIndexOf(colours, "Orange");
        System.out.println("lastIndexOfOrange = " + lastIndexOfOrange);
    }
}
