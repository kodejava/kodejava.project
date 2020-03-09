package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELRegexExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-regex.xml");

        User user = (User) context.getBean("user");
        System.out.println("user.getEmail()     = " + user.getEmail());
        System.out.println("user.isEmailValid() = " + user.isEmailValid());

        User user2 = (User) context.getBean("user2");
        System.out.println("user.getEmail()     = " + user2.getEmail());
        System.out.println("user.isEmailValid() = " + user2.isEmailValid());
    }
}
