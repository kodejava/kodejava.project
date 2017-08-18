package org.kodejava.example.lang;

public class GetCurrentThreadDemo {
    public static void main(String[] args){
        // Get the currently executing thread object
        Thread thread = Thread.currentThread();
        System.out.println("Id      : " + thread.getId());
        System.out.println("Name    : " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
    }
}
