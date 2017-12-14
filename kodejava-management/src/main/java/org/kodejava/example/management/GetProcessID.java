package org.kodejava.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class GetProcessID {
    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();

        // Get name representing the running Java virtual machine.
        // It returns something like 6460@AURORA. Where the value
        // before the @ symbol is the PID.
        String jvmName = bean.getName();
        System.out.println("Name = " + jvmName);

        // Extract the PID by splitting the string returned by the
        // bean.getName() method.
        long pid = Long.valueOf(jvmName.split("@")[0]);
        System.out.println("PID  = " + pid);
    }
}
