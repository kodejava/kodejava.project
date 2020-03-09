package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELEnvironment {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-environment.xml");

        Program program1 = (Program) context.getBean("program1");
        System.out.println("program.getLogPath() = " + program1.getLogPath());

        Program program2 = (Program) context.getBean("program2");
        System.out.println("program.getLogPath() = " + program2.getLogPath());
    }
}
