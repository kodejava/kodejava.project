package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELStaticDemo {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spring-spel-static.xml");

        MyOtherBean bean = (MyOtherBean) context.getBean("myBean");
        System.out.println("bean.getRandomNumber() = " + bean.getRandomNumber());
        System.out.println("bean.getPi()           = " + bean.getPi());
        System.out.println("bean.getName()         = " + bean.getName());
    }
}
