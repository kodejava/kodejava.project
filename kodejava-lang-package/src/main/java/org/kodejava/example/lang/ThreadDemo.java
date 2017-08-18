package org.kodejava.example.lang;

public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        // Creates an instance of this class.
        ThreadDemo thread1 = new ThreadDemo();

        // Creates a runnable object.
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    sayHello();
                }
            }
        });

        // Set thread priority, the normal priority of a thread is 5.
        thread1.setPriority(4);
        thread2.setPriority(6);

        // Start the execution of thread1 and thread2
        thread1.start();
        thread2.start();

        for (int i = 0; i < 5; i++) {
            sayHello();
        }
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sayHello();
        }
    }

    /**
     * The synchronized modifier ensure that two threads cannot execute the block
     * at the same time.
     */
    private static synchronized void sayHello() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread [" + Thread.currentThread().getName() +  "] ==> Hi...");
        }

        try {
            // Causes the currently executing thread to sleep for a random
            // milliseconds
            Thread.sleep((long) (Math.random() * 1000 + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Causes the currently executing thread object to temporarily pause
        // and allow other threads to execute.
        Thread.yield();
    }
}
