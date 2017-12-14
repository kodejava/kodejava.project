package org.kodejava.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;
import java.util.Set;

public class GetSystemProperties {
    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();

        // Returns a map of names and values of all system
        // properties. This method calls System.getProperties()
        // to get all system properties. Properties whose
        // name or value is not a String are omitted.
        Map<String, String> systemProperties = bean.getSystemProperties();
        Set<String> keys = systemProperties.keySet();
        for (String key : keys) {
            String value = systemProperties.get(key);
            System.out.printf("Property[%s] = %s.%n", key, value);
        }
    }
}
