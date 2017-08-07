package org.kodejava.example.lang;

public class IntegerProperty {
    public static void main(String[] args) {
        // Add properties to the system. In this example we create a
        // dummy major and minor version for our application.
        System.setProperty("app.major.version", "1");
        System.setProperty("app.minor.version", "19");
        
        // In the code below we use the Integer.getInteger() method to
        // read our application version from the value specified in the
        // system properties.
        Integer major = Integer.getInteger("app.major.version");
        Integer minor = Integer.getInteger("app.minor.version");
        System.out.println("App version = " + major + "." + minor);
    }
}
