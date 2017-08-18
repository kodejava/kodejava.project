package org.kodejava.example.lang;

public class ThreadAliveDemo implements Runnable {

    public void run() {
        System.out.println("Running [" +
            Thread.currentThread().getName() + "].");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadAliveDemo(), "FirstThread");
        Thread t2 = new Thread(new ThreadAliveDemo(), "SecondThread");

        // start the t1
        t1.start();

        // Check to see if the first thread is alive or not.
        if (t1.isAlive()) {
            System.out.format("%s is alive.%n", t1.getName());
        } else {
            System.out.format("%s is not alive.%n", t1.getName());
        }

        // Check to see if the second thread is alive or not.
        // It should be return false because t2 hasn't been started.
        if (t2.isAlive()) {
            System.out.format("%s is alive.%n", t2.getName());
        } else {
            System.out.format("%s is not alive.%n", t2.getName());
        }
    }
}
