package org.kodejava.example.lang;

public class GetThreadState implements Runnable {
    public void run() {
        System.out.println("Start..");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new GetThreadState());
        thread.start();

        // Get the state of the thread.
        Thread.State state = thread.getState();
        System.out.println("State: " + state.name());
    }
}
