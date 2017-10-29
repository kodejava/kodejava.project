package org.kodejava.example.util;

import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionToArrayList {
    public static void main(String[] args) {
        // We create LinkedList collection type at put some values
        // in it. Here we put A, B, C and D letter into it.
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");

        // Let say you want to convert it to other type of collection,
        // for instance here we convert it into ArrayList. To do it
        // we can pass the collection created above as a parameter to
        // ArrayList constructor.
        ArrayList<String> arrayList = new ArrayList<String>(linkedList);

        // Now we have converted the collection into ArrayList and
        // printed what is inside.
        for (String s : arrayList) {
            System.out.println("s = " + s);
        }
    }
}
