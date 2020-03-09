package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELFilterCollection {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-filter-collection.xml");

        System.out.println("Library 1");
        Library lib1 = (Library) context.getBean("lib1");
        for (Book book : lib1.getBooks()) {
            System.out.println("    Book = " + book);
        }

        System.out.println("Library 2");
        Library lib2 = (Library) context.getBean("lib2");
        for (Book book : lib2.getBooks()) {
            System.out.println("    Book = " + book);
        }

        System.out.println("Library 3");
        Library lib3 = (Library) context.getBean("lib3");
        for (Book book : lib3.getBooks()) {
            System.out.println("    Book = " + book);
        }
    }
}
