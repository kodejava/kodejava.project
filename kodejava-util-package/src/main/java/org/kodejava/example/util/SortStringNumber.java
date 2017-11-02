package org.kodejava.example.util;

import java.util.Arrays;
import java.util.Collections;

public class SortStringNumber {
    public static void main(String[] args) {
        // We have some string numbers separated by comma. First we
        // need to split it so we can get each individual number.
        String data = "2, 5, 9, 1, 10, 7, 4, 8";
        String[] numbers = data.split(",");

        // Convert the string numbers into Integer and placed it into
        // an array of Integer.
        Integer[] intValues = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            intValues[i] = Integer.parseInt(numbers[i].trim());
        }

        // Sort the number in ascending order using the
        // Collections.sort() method.
        Collections.sort(Arrays.asList(intValues));

        // Convert back the sorted number into string using the
        // StringBuilder object. Prints the sorted string numbers.
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intValues.length; i++) {
            Integer intValue = intValues[i];
            builder.append(intValue);
            if (i < intValues.length - 1) {
                builder.append(", ");
            }
        }
        System.out.println("Before = " + data);
        System.out.println("After  = " + builder.toString());
    }
}
