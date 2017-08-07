package org.kodejava.example.lang;

public class ObtainingSuperClass {
    public static void main(String[] args) {
        // Create an instance of String class
        Object object1 = new String("Hello");

        // Get String class super class
        Class clazz1 = object1.getClass().getSuperclass();
        System.out.println("Super Class = " + clazz1);

        // Create an instance of StringIndexOutOfBoundsException class
        Object object2 = new StringIndexOutOfBoundsException("Error message");

        // Get StringIndexOutOfBoundsException class super class
        Class clazz2 = object2.getClass().getSuperclass();
        System.out.println("Super Class = " + clazz2);
    }
}
