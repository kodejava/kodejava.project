package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELMapExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-map.xml");

        Book book1 = (Book) context.getBean("book1");
        Book book2 = (Book) context.getBean("book2");

        System.out.println("book1.getTitle() = " + book1.getTitle());
        System.out.println("book2.getTitle() = " + book2.getTitle());
    }
}
