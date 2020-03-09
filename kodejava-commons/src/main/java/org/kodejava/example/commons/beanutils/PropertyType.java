package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

public class PropertyType {
    public static void main(String[] args) {
        Recording recording = new Recording();
        recording.setTitle("Magical Mystery Tour");

        try {
            /*
             * Using PropertyUtils.getPropertyType() to determine the type of
             * title property.
             */
            Class type = PropertyUtils.getPropertyType(recording, "title");
            System.out.println("type = " + type.getName());

            String value = (String) PropertyUtils.getProperty(recording, "title");
            System.out.println("value = " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
