package org.kodejava.example.commons.lang;

import org.apache.commons.lang.ArrayUtils;

public class ArrayObjectToPrimitiveDemo {
    public static void main(String[] args) {
        // An array of Integer objects.
        Integer[] integers = {1, 2, 3, 5, 8, 13, 21, 34, 55};
        Boolean[] booleans = {Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE};

        // Convert array of Integer objects into array of type int.
        int[] ints = ArrayUtils.toPrimitive(integers);
        System.out.println(ArrayUtils.toString(ints));

        // Convert array of Boolean objects into array of type boolean.
        boolean[] bools = ArrayUtils.toPrimitive(booleans);
        System.out.println(ArrayUtils.toString(bools));
    }
}
