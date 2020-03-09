package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticELDemo {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-static.xml");

        NumberGenerator number = (NumberGenerator) context.getBean("bean");
        System.out.println("Random number: " + number.getRandomNumber());
    }
}
