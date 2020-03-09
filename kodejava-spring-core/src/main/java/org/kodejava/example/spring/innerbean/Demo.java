package org.kodejava.example.spring.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"inner-bean.xml"});

        Racer racer = (Racer) context.getBean("racer");
        System.out.println("Racer = " + racer);
    }
}
