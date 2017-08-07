package org.kodejava.example.lang;

public class DelayExample {
    public static void main(String[] args) {
        // This program demonstrate how to add a delay in our 
        // application.
        for (int i = 0; i < 10; i++) {
            // Print the value of i
            System.out.println("i = " + i);

            try {
                // Using Thread.sleep() we can add delay in our 
                // application in a millisecond time. For the example 
                // below the program will take a deep breath for one 
                // second before continue to print the next value of 
                // the loop.
                Thread.sleep(1000);

                // The Thread.sleep() need to be executed inside a 
                // try-catch block and we need to catch the 
                // InterruptedException.
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
