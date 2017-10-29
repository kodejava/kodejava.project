package org.kodejava.example.util;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        // Create an instance of a queue, ere we use the LinkedList class which
        // implements the Queue interface. Add some elements to the queue using
        // the offer method.
        Queue<String> queue = new LinkedList<>();
        queue.offer("First visitor");
        queue.offer("Second visitor");
        queue.offer("Third visitor");
        queue.offer("Fourth visitor");

        // Let see the size of our queue
        System.out.println("Size: " + queue.size());

        // The peek and element method read the head of the queue without removing
        // the element. The difference is, if the queue is empty peek method
        // return null while element method throws a NoSuchElementException
        // exception.
        System.out.println("Queue head using peek   : " + queue.peek());
        System.out.println("Queue head using element: " + queue.element());

        // The poll method retrieves and then removes the head of the queue.
        // On the next code will process all the element of the queue. When no
        // item in the queue the poll method will return null.
        Object data;
        while ((data = queue.poll()) != null) {
            System.out.println(data);
        }
    }
}
