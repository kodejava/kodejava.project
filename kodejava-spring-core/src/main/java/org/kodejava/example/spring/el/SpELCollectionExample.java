package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELCollectionExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-collection.xml");

        Book book = (Book) context.getBean("book");
        System.out.println("book.getTitle() = " + book.getTitle());
        System.out.println("book.getAuthor() = " + book.getAuthor());
    }
}
