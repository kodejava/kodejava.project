package org.kodejava.example.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class RawIPToString {
    public static void main(String[] args) {
        byte[] ip = new byte[0];
        try {
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ipAddress = RawIPToString.getIpAddress(ip);
        System.out.println("IP Address = " + ipAddress);

        try {
            InetAddress address = InetAddress.getByName("google.com");
            ip = address.getAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        ipAddress = RawIPToString.getIpAddress(ip);
        System.out.println("IP Address = " + ipAddress);
    }

    /**
     * Convert raw IP address to string.
     *
     * @param rawBytes raw IP address.
     * @return a string representation of the raw ip address.
     */
    private static String getIpAddress(byte[] rawBytes) {
        int i = 4;
        StringBuilder ipAddress = new StringBuilder();
        for (byte raw : rawBytes) {
            ipAddress.append(raw & 0xFF);
            if (--i > 0) {
                ipAddress.append(".");
            }
        }
        return ipAddress.toString();
    }
}
