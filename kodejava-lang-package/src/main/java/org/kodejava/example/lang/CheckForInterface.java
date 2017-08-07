package org.kodejava.example.lang;

public class CheckForInterface {
    public static void main(String[] args) {
        // Checking whether Cloneable is an interface or class
        Class clazz = Cloneable.class;
        boolean isInterface = clazz.isInterface();
        System.out.println("Cloneable is an interface = " + isInterface);

        // Checking whether String is an interface or class
        clazz = String.class;
        isInterface = clazz.isInterface();
        System.out.println("String is an interface    = " + isInterface);
    }
}

