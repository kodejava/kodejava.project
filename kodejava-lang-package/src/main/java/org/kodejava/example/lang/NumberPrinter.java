package org.kodejava.example.lang;

public class NumberPrinter extends Thread {
    private String threadName;
    private int delay;

    public NumberPrinter(String threadName, int delay) {
        this.threadName = threadName;
        this.delay = delay;
    }

    // The run() method will be invoked when the thread is started.
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread [" + threadName + "] = " + i);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NumberPrinter printerA = new NumberPrinter("A", 1000);
        NumberPrinter printerB = new NumberPrinter("B", 750);

        printerA.start();
        printerB.start();
    }
}
