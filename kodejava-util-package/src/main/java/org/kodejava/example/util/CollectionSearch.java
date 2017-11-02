package org.kodejava.example.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;
import java.text.DateFormatSymbols;

public class CollectionSearch {
    public static void main(String[] args) {
        DateFormatSymbols dfs = new DateFormatSymbols();

        LinkedList<String> monthList = new LinkedList<>();
        monthList.addAll(Arrays.asList(dfs.getMonths()));

        // Sort the collection elements
        Collections.sort(monthList);
        System.out.println("Months = " + monthList);

        // Get the position of November inside the monthList. It returns a positive
        // value if the item found in the monthList.
        int index = Collections.binarySearch(monthList, "November");
        if (index > 0) {
            System.out.println("Found at index = " + index);
            System.out.println("Month = " + monthList.get(index));
        }
    }
}
