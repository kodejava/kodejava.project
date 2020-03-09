package org.kodejava.example.spring.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingBeanDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"drawing-bean.xml"});
        DrawingBean bean = (DrawingBean) context.getBean("drawingBean");
        bean.drawShape();
    }
}
