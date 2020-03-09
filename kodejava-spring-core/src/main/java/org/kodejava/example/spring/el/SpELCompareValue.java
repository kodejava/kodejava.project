package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELCompareValue {
    public static void main(String[] args) {
        ApplicationContext context = new
            ClassPathXmlApplicationContext("spel-compare-value.xml");

        MyGlass glass = (MyGlass) context.getBean("myGlass");
        System.out.println("glass.getVolume()   = " + glass.getVolume());
        System.out.println("glass.isEmpty()     = " + glass.isEmpty());
        System.out.println("glass.isHalfEmpty() = " + glass.isHalfEmpty());
    }
}
