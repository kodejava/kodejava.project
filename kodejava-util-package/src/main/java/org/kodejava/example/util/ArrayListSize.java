package org.kodejava.example.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSize {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        int size = list.size();
        System.out.println("List size = " + size);
    }
}
