package org.kodejava.example.lang.thread;

public class Incrementor {
    private int count;

    // A synchronized method example.
    public synchronized void increment(int value) {
        count += value;
        System.out.println(Thread.currentThread().getName() +
            ": inc >>> " + count);
    }

    public void decrement(int value) {
        // A synchronized block example the use the current object instance
        // as the monitor object.
        synchronized (this) {
            count -= value;
            System.out.println(Thread.currentThread().getName() +
                ": dec >>> " + count);
        }
    }
}
