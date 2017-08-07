package org.kodejava.example.lang;

public class ElapsedTimeExample {
    public static void main(String[] args) {
        // Get the start time of the process
        long start = System.nanoTime();
        System.out.println("Start: " + start);

        // Just do some a bit long process calculating the total value
        // of even number from zero to 10000
        int totalEven = 0;
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                totalEven = totalEven + i;
            }
        }

        // Get the end time of the process
        long end = System.nanoTime();
        System.out.println("End  : " + end);

        long elapsedTime = end - start;

        // Show how long it took to finish the process
        System.out.println("The process took approximately: "
            + elapsedTime + " nano seconds");
    }
}
