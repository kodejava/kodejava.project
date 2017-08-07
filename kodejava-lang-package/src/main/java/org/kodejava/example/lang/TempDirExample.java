package org.kodejava.example.lang;

public class TempDirExample {
    public static void main(String[] args) {
        // This is the property name for accessing OS temporary directory
        // or folder.
        String property = "java.io.tmpdir";

        // Get the temporary directory and print it.
        String tempDir = System.getProperty(property);
        System.out.println("OS temporary directory is " + tempDir);
    }
}
