package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

public class ObjectArrayClone {
    public static void main(String[] args) {
        String[] colors = new String[] {"Red", "Green", "Blue", "Yellow"};
        System.out.println("colors = " + ArrayUtils.toString(colors));

        String[] clone = ArrayUtils.clone(colors);
        System.out.println("clone = " + ArrayUtils.toString(clone));
    }
}
