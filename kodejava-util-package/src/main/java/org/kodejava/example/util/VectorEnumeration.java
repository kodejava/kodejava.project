package org.kodejava.example.util;

import java.util.Enumeration;
import java.util.Vector;

public class VectorEnumeration {

    public static void main(String[] args) {
        Vector<String> data = new Vector<>();
        data.add("one");
        data.add("two");
        data.add("three");

        StringBuilder sb = new StringBuilder("Data: ");

        // Iterates vector object to read it elements
        for (Enumeration enumeration = data.elements();
             enumeration.hasMoreElements();) {
            sb.append(enumeration.nextElement()).append(",");
        }

        // Delete the last ","
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
