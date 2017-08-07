package org.kodejava.example.lang;

import java.util.HashMap;
import java.util.Map;

public class Autoboxing {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // Here we put an int into the Map, and it accepted
        // as it will be autoboxed or converted into the wrapper
        // of this type, in this case the Integer object.
        map.put("Age", 25);

        // Here we can just get the value from the map, no need
        // to cast it from Integer to int.
        int age = map.get("Age");

        // Here we simply do the math on the primitive type
        // and got the result as an Integer.
        Integer newAge = age + 10;
    }
}
