package org.kodejava.example.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldDemo {
    public static void main(String[] args) {
        String config = "spring.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        Hello hello = (Hello) context.getBean("hello");
        hello.sayHello();
    }
}
