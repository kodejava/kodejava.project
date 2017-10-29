package org.kodejava.example.util;

import java.util.Arrays;
import java.util.Collections;

public class SortArrayWithOrder {
    public static void main(String[] args) {
        Integer[] points = new Integer[5];
        points[0] = 94;
        points[1] = 53;
        points[2] = 70;
        points[3] = 44;
        points[4] = 64;
        System.out.println("Original  : " + Arrays.toString(points));

        // Sort the points array, the default order is in ascending order.
        // [44, 53, 64, 70, 94]
        Arrays.sort(points);
        System.out.println("Ascending : " + Arrays.toString(points));

        // Sort the points array in descending order.
        // [94, 70, 64, 53, 44]
        Arrays.sort(points, Collections.reverseOrder());
        System.out.println("Descending: " + Arrays.toString(points));
    }
}
