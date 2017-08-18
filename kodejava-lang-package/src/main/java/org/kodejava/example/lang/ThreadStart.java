package org.kodejava.example.lang;

public class ThreadStart extends Thread {

    public static void main(String[] args) {
        ThreadStart thread = new ThreadStart();

        // Start this thread
        thread.start();
    }

    /**
     * The run() method will be invoked when the thread is started.
     */
    @Override
    public void run() {
        System.out.println("Running..");
    }
}
