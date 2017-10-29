package org.kodejava.example.util;

import java.util.*;

public class EmptyCollectionDemo {
    public static void main(String args[]) {
        List list = Collections.EMPTY_LIST;
        System.out.println("list.size()  = " + list.size());
        Set set = Collections.EMPTY_SET;
        System.out.println("set.size()   = " + set.size());
        Map map = Collections.EMPTY_MAP;
        System.out.println("map.size()   = " + map.size());

        // For the type-safe example use the following methods.
        List<String> strings = Collections.emptyList();
        System.out.println("strings.size = " + strings.size());

        Set<Long> longs = Collections.emptySet();
        System.out.println("longs.size() = " + longs.size());

        Map<String, Date> dates = Collections.emptyMap();
        System.out.println("dates.size() = " + dates.size());
    }
}
