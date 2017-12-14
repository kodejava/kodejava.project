package org.kodejava.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class PeakThreadCount {
    public static void main(String[] args) {
        // Get the managed bean for the thread system of the Java
        // virtual machine.
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        // Get the peak live thread count since the Java virtual
        // machine started or peak was reset.
        int peakThreadCount = bean.getPeakThreadCount();
        System.out.println("Peak Thread Count = " + peakThreadCount);
    }
}
