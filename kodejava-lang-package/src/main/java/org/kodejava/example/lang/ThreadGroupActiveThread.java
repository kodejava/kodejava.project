package org.kodejava.example.lang;

public class ThreadGroupActiveThread {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("TestThread");

        Thread t1 = new Thread(threadGroup, new Server(), "Server1");
        Thread t2 = new Thread(threadGroup, new Server(), "Server2");
        Thread t3 = new Thread(threadGroup, new Server(), "Server3");
        Thread t4 = new Thread(threadGroup, new Server(), "Server4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Get an estimate number of active thread of the thread
        // group.
        int activeThread = threadGroup.activeCount();
        System.out.format("Number of active threads of %s is %d %n",
            threadGroup.getName(), activeThread);
    }
}

class Server implements Runnable {
    public void run() {
        System.out.println("Running..");
    }
}
