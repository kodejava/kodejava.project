package org.kodejava.example.lang;

public class MemoryExample {
    public static void main(String[] args) {
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("Free Memory  = " + freeMemory);
        System.out.println("Total Memory = " + totalMemory);
    }
}
