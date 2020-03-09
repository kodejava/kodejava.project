package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELLogicalExpression {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-logical-expression.xml");

        MyOtherGlass smallGlass =
            (MyOtherGlass) context.getBean("smallGlass");
        MyOtherGlass largeGlass =
            (MyOtherGlass) context.getBean("largeGlass");

        System.out.println("smallGlass.isLargeGlass() = " + smallGlass.isLargeGlass());
        System.out.println("largeGlass.isLargeGlass() = " + largeGlass.isLargeGlass());
    }
}
