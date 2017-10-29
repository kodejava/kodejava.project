package org.kodejava.example.util;

import java.util.*;

public class ResourceBundleToProperties {
    public static void main(String[] args) {
        // Load resource bundle Messages_en_GB.properties from the classpath.
        ResourceBundle resource = ResourceBundle.getBundle("Messages", Locale.UK);

        // Call the convertResourceBundleToProperties method to convert the resource
        // bundle into a Properties object.
        Properties properties = convertResourceBundleToProperties(resource);

        // Print the entire contents of the Properties.
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = (String) properties.get(key);
            System.out.println(key + " = " + value);
        }
    }

    /**
     * Convert ResourceBundle into a Properties object.
     *
     * @param resource a resource bundle to convert.
     * @return Properties a properties version of the resource bundle.
     */
    private static Properties convertResourceBundleToProperties(ResourceBundle resource) {
        Properties properties = new Properties();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            properties.put(key, resource.getString(key));
        }
        return properties;
    }
}
