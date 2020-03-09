package org.kodejava.example.spring.singer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingerDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("singer.xml");

        Singer singer = (Singer) context.getBean("singer");
        singer.sing();
    }
}
