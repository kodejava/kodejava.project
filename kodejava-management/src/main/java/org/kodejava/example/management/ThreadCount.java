package org.kodejava.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadCount {

    public static void main(String[] args) {
        // Get the managed bean for the thread system of the Java
        // virtual machine.
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        // Get the current number of live threads including both
        // daemon and non-daemon threads.
        int threadCount = bean.getThreadCount();
        System.out.println("Thread Count = " + threadCount);
    }
}
