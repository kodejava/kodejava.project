package org.kodejava.example.lang;

public class DaemonThread implements Runnable {
    private String threadName;

    private DaemonThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        System.out.println("Running [" + threadName + "]");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonThread("FirstThread"));
        Thread t2 = new Thread(new DaemonThread("SecondThread"));

        // t1 is as daemon thread
        t1.setDaemon(true);
        t1.start();

        // t2 is a user thread
        t2.start();
    }
}
