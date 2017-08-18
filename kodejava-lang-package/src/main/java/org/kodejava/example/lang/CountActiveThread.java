package org.kodejava.example.lang;

public class CountActiveThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello...");
            }
        });
        t.start();

        // Get the number of active threads in the current thread's
        // thread group.
        int activeThread = Thread.activeCount();
        System.out.format("Number of active threads of %s is %d %n",
            Thread.currentThread().getName(), activeThread);
    }
}
