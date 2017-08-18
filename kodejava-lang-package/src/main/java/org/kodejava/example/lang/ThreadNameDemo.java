package org.kodejava.example.lang;

public class ThreadNameDemo extends Thread {
    public ThreadNameDemo() {
    }

    public ThreadNameDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        // Call getName() method to get the thread name of this
        // thread object.
        System.out.println("Running [" + this.getName() + "]");
    }

    public static void main(String[] args) {
        Thread thread1 = new ThreadNameDemo();
        thread1.setName("FOX");
        thread1.start();

        Thread thread2 = new ThreadNameDemo("DOG");
        thread2.start();
    }
}
