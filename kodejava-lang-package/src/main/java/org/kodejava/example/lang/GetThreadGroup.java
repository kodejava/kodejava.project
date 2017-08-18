package org.kodejava.example.lang;

public class GetThreadGroup {
    public static void main(String[] args) {
        // Create thread groups
        ThreadGroup group = new ThreadGroup("ThreadGroup");
        ThreadGroup anotherGroup = new ThreadGroup(group, "AnotherGroup");

        // Create threads and placed into thread group
        Thread t1 = new Thread(group, new FirstThread(), "Thread1");
        Thread t2 = new Thread(anotherGroup, new FirstThread(), "Thread2");

        // Start the threads
        t1.start();
        t2.start();

        // Use getThreadGroup() method of Thread class to get the object
        // of ThreadGroup then use the getName() method to get the name
        // of thread group.
        System.out.format("%s is a member of %s%n", t1.getName(),
            t1.getThreadGroup().getName());
        System.out.format("%s is a member of %s%n", t2.getName(),
            t2.getThreadGroup().getName());
    }
}

class FirstThread implements Runnable {
    public void run() {
        System.out.println("Start..");
    }
}
