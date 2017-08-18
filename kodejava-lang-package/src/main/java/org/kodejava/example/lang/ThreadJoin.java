package org.kodejava.example.lang;

public class ThreadJoin implements Runnable {
    private int numberOfLoop;

    private ThreadJoin(int numberOfLoop) {
        this.numberOfLoop = numberOfLoop;
    }

    public void run() {
        System.out.println("[" +
            Thread.currentThread().getName() + "] - Running.");

        for (int i = 0; i < this.numberOfLoop; i++) {
            System.out.println("[" +
                Thread.currentThread().getName() + "] " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[" +
            Thread.currentThread().getName() + "] - Done.");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadJoin(10), "FirstThread");
        Thread t2 = new Thread(new ThreadJoin(20), "SecondThread");

        try {
            // start t1 and waits for this thread to die before
            // starting the t2 thread.
            t1.start();
            t1.join();

            // start t2
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
