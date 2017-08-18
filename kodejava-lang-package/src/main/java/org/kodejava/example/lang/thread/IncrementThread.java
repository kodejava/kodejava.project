package org.kodejava.example.lang.thread;

public class IncrementThread implements Runnable {
    private Incrementor incrementor;

    public IncrementThread(Incrementor incrementor) {
        this.incrementor = incrementor;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            incrementor.increment(i * 10);
            incrementor.decrement(i * 2);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
