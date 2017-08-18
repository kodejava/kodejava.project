package org.kodejava.example.lang;

public class CodeSourceLocation {
    public static void main(String[] args) {
        CodeSourceLocation csl = new CodeSourceLocation();
        csl.getCodeSourceLocation();
    }

    private void getCodeSourceLocation() {
        // The the location from where the class is loaded.
        System.out.println("Code source location: " +
            getClass().getProtectionDomain().getCodeSource().getLocation());
    }
}
