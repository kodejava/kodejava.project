package org.kodejava.example.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStringForEveryNChar {
    public static void main(String[] args) {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(Arrays.toString(splitToNChar(text, 3)));
        System.out.println(Arrays.toString(splitToNChar(text, 4)));
        System.out.println(Arrays.toString(splitToNChar(text, 5)));
    }

    /**
     * Split text into n number of characters.
     *
     * @param text the text to be split.
     * @param size the split size.
     * @return an array of the split text.
     */
    private static String[] splitToNChar(String text, int size) {
        List<String> parts = new ArrayList<>();

        int length = text.length();
        for (int i = 0; i < length; i += size) {
            parts.add(text.substring(i, Math.min(length, i + size)));
        }
        return parts.toArray(new String[0]);
    }
}
