package org.kodejava.example.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostNameExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();

            System.out.println("Hostname: " + address.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
