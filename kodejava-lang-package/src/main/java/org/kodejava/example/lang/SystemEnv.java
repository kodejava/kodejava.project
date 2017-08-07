package org.kodejava.example.lang;

import java.util.Map;
import java.util.Set;

public class SystemEnv {
    public static void main(String[] args) {
        // We get the environment information from the System class. 
        // The getenv method (why shouldn't it called getEnv()?) 
        // returns a map that will never have null keys or values 
        // returned.
        Map<String, String> map = System.getenv();

        Set<String> keys = map.keySet();
        for (String key : keys) {
            // Here we iterate based on the keys inside the map, and
            // with the key in hand we can get it values.
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
