package org.kodejava.example.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayListContainsExample {
    private List<String> list = new ArrayList<>();

    public ArrayListContainsExample() {
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
    }

    public static void main(String[] args) {
        ArrayListContainsExample demo = new ArrayListContainsExample();

        // Check to see if the list contains "Item 1".
        String itemToFind = "Item 1";
        demo.findItemInTheList(itemToFind);

        // Check to see if the list contains "Item 20".
        itemToFind = "Item 20";
        demo.findItemInTheList(itemToFind);
    }

    private void findItemInTheList(String itemToFind) {
        if (list.contains(itemToFind)) {
            System.out.println(itemToFind + " was found in the list");
        } else {
            System.out.println(itemToFind + " was not found in the list");
        }
    }
}
