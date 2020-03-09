package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELFilterProjectionExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-filter-projection.xml");

        Library library = context.getBean("library", Library.class);

        for (String title : library.getBookTitles()) {
            System.out.println("title = " + title);
        }
    }
}
