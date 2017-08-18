package org.kodejava.example.lang;

public class ThreadRun implements Runnable {

    public static void main(String[] args) {
        // Instantiate ThreadRun
        ThreadRun runner = new ThreadRun();

        // Create instance of Thread and passing ThreadRun object
        // as argument.
        Thread thread = new Thread(runner);

        // By passing Runnable object, it tells the
        // thread to use run() of Runnable object.
        thread.start();
    }

    public void run() {
        System.out.println("Running..");
    }
}
