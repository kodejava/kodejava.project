package org.kodejava.example.lang;

public class NanosecondsTimerResolution {
    public static void main(String[] args) {
        // Get process execution start time in nanoseconds.
        long start = System.nanoTime();
        System.out.println("Process start... " + start);

        try {
            Thread.sleep(5000); // Simulate a long process.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get process execution finish time in nanoseconds.
        long finish = System.nanoTime();
        System.out.println("Process finish... " + finish);

        // Calculate the process execution time.
        long execTime = finish - start;
        System.out.println("Processing time = " + execTime + "(ns)");
    }
}
