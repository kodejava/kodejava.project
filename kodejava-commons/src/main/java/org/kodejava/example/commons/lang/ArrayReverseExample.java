package org.kodejava.example.commons.lang;

import org.apache.commons.lang.ArrayUtils;

public class ArrayReverseExample {

    public static void main(String[] args) {
        // Define colors array.
        String[] colors = {"Red", "Green", "Blue", "Cyan", "Yellow", "Magenta"};
        System.out.println(ArrayUtils.toString(colors));

        // Now we reverse the order of array elements. 
        ArrayUtils.reverse(colors);
        System.out.println(ArrayUtils.toString(colors));
    }
}
