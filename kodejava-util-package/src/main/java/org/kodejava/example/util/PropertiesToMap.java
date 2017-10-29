package org.kodejava.example.util;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class PropertiesToMap {
    public static void main(String[] args) {
        // Create a new instance of Properties.
        Properties properties = new Properties();

        // Populate properties with a dummy application information
        properties.setProperty("app.name", "HTML Designer");
        properties.setProperty("app.version", "1.0");
        properties.setProperty("app.vendor", "HTML Designer Inc");

        // Create a new HashMap and pass an instance of Properties. Properties
        // is an implementation of a Map which keys and values stored as in a
        // String.
        Map<Object, Object> map = new HashMap<>(properties);

        // Get the entry set of the Map and print it out.
        Set propertySet = map.entrySet();
        for (Object o : propertySet) {
            Map.Entry entry = (Map.Entry) o;
            System.out.printf("%s = %s%n", entry.getKey(), entry.getValue());
        }
    }
}
