package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELNullSafeExpressionDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spel-null-safe.xml");

        Student student = (Student) context.getBean("student");
        System.out.println("Name  = " + student.getName());
        System.out.println("Grade = " + student.getGrade());
    }
}
