package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELPropertiesExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-properties.xml");

        MyDataSource dataSource = (MyDataSource) context.getBean("dataSource");
        System.out.println("driverClassName = " + dataSource.getDriverClassName());
        System.out.println("url             = " + dataSource.getUrl());
        System.out.println("username        = " + dataSource.getUsername());
        System.out.println("password        = " + dataSource.getPassword());
    }
}
