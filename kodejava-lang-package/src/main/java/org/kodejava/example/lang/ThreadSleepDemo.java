package org.kodejava.example.lang;

public class ThreadSleepDemo implements Runnable {
    // The run() method will be invoked when the thread is started.
    public void run() {
        System.out.println("Start..");
        try {
            // Wait for 10 seconds
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish...");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadSleepDemo());
        thread.start();
    }
}
