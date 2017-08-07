package org.kodejava.example.lang;

public class OperatingSystemInfo {
    public static void main(String[] args) {
        // The key for getting operating system name
        String name = "os.name";
        // The key for getting operating system version
        String version = "os.version";
        // The key for getting operating system architecture
        String architecture = "os.arch";

        System.out.println("Name   : " + System.getProperty(name));
        System.out.println("Version: " + System.getProperty(version));
        System.out.println("Arch   : " + System.getProperty(architecture));
    }
}
