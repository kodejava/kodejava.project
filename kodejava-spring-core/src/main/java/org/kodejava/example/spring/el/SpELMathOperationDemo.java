package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELMathOperationDemo {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-math-operation.xml");

        MyBean bean = (MyBean) context.getBean("myBean");
        System.out.println("bean.getTotal()    = " + bean.getTotal());
        System.out.println("bean.getLength()   = " + bean.getLength());
        System.out.println("bean.getSize()     = " + bean.getSize());
        System.out.println("bean.getReminder() = " + bean.getReminder());
        System.out.println("bean.getDistance() = " + bean.getDistance());
        System.out.println("bean.getPower()    = " + bean.getPower());
    }
}
