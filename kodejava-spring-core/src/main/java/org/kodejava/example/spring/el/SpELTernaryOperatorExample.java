package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELTernaryOperatorExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-ternary.xml");

        Book book1 = (Book) context.getBean("book1");
        Book book2 = (Book) context.getBean("book2");
        Book book3 = (Book) context.getBean("book3");

        System.out.println("book1.getType() = " + book1.getType());
        System.out.println("book2.getType() = " + book2.getType());
        System.out.println("book3.getType() = " + book3.getType());

    }
}
