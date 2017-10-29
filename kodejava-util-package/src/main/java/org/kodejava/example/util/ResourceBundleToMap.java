package org.kodejava.example.util;

import java.util.*;

public class ResourceBundleToMap {
    public static void main(String[] args) {
        // Load resource bundle Messages_en_GB.properties from the classpath.
        ResourceBundle resource = ResourceBundle.getBundle("Messages", Locale.UK);

        // Call the convertResourceBundleTopMap method to convert the resource
        // bundle into a Map object.
        Map<String, String> map = convertResourceBundleToMap(resource);

        // Print the entire contents of the Map.
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }

    /**
     * Convert ResourceBundle into a Map object.
     *
     * @param resource a resource bundle to convert.
     * @return Map a map version of the resource bundle.
     */
    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }
        return map;
    }
}
