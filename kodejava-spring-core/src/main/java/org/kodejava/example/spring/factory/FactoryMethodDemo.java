package org.kodejava.example.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("factory-method.xml");

        Singleton instance =
                (Singleton) context.getBean("singleton");
        instance.doSomething();
    }
}
