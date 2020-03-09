package org.kodejava.example.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoSet {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"collection-set.xml"});

        Album album = (Album) context.getBean("album");
        System.out.println("Album = " + album);
    }
}
