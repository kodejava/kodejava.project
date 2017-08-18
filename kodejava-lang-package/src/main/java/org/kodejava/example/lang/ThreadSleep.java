package org.kodejava.example.lang;

import java.util.Calendar;

public class ThreadSleep implements Runnable {
    private String threadName;
    private long sleep;

    public ThreadSleep(String threadName, long sleep) {
        this.threadName = threadName;
        this.sleep = sleep;
    }

    // The run() method will be invoked when the thread is started.
    public void run() {
        System.out.println("Start thread [" + this.threadName + "]");
        try {
            while (true) {
                // Pause the thread for "sleep" milliseconds.
                Thread.sleep(this.sleep);
                System.out.println("[" + threadName + "]" +
                    Calendar.getInstance().getTime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish thread [" + this.threadName + "]");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadSleep("FirstThread", 1000));
        Thread thread2 = new Thread(new ThreadSleep("SecondThread", 3000));

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
