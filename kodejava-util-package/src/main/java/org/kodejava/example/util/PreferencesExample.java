package org.kodejava.example.util;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesExample {
    public static void main(String[] args) {
        PreferencesExample demo = new PreferencesExample();
        demo.setPreferences();
    }

    private void setPreferences() {
        // Define a node to store the preferences data.
        Preferences pref = Preferences.userRoot().node(getClass().getName());

        String key1 = "KEY1";
        String key2 = "KEY2";
        String key3 = "KEY3";

        // Read the value of KEY1, return an empty string if the value
        // hasn't been set previously.
        String key1Value = pref.get(key1, "");
        System.out.println("KEY1: " + key1Value);

        // Read the value of KEY2 as an integer, if the value hasn't
        // been set previously return -1.
        int key2Value = pref.getInt(key2, -1);
        System.out.println("KEY2: " + key2Value);

        // Read the value of KEY3, return true if no value was set
        // previously.
        boolean key3Value = pref.getBoolean(key3, true);
        System.out.println("KEY3: " + key3Value);

        // Set the values for all of the preference key above.
        if (key1Value.equals("")) {
            pref.put(key1, "January");
        }
        if (key2Value == -1) {
            pref.putInt(key2, 1000);
        }
        if (key3Value) {
            pref.putBoolean(key3, false);
        }

        printKeys(pref);

        // Remove KEY1 from the preferences data.
        pref.remove(key1);
        printKeys(pref);

        try {
            // Remove all preference data of this node.
            pref.clear();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }

        printKeys(pref);
    }

    /**
     * Print Keys in the preferences node.
     * @param pref Preference node.
     */
    private void printKeys(Preferences pref) {
        System.out.println("PreferencesExample.printKeys");
        try {
            String[] keys = pref.keys();
            for (String key : keys) {
                System.out.println("Key = " + key);
            }
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
        System.out.println("============================");
    }
}
