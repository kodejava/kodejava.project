package org.kodejava.example.lang.thread;

public class IncrementorDemo {
    public static void main(String[] args) {
        Incrementor incrementor = new Incrementor();

        Thread t1 = new Thread(new IncrementThread(incrementor), "T1");
        Thread t2 = new Thread(new IncrementThread(incrementor), "T2");

        t1.start();
        t2.start();
    }
}
