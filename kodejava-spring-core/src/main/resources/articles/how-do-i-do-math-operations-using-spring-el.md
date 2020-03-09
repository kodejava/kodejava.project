# How do I do math operations using Spring EL?

As we know that the simplest value that can be expressed in the Spring EL is a literal value such as number. Further more we can also do math operations using the Spring EL. The spring configuration below show you how can do math operations using the Spring Expression Language. These operations includes:

* Add operation (`+`)
* Subtract operation (`-`)
* Multiply operation (`*`)
* Divide operations (`/`)
* Modulo operation (`%`)
* Power operation (`^`)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="org.kodejava.example.spring.el.MyBean">
        <property name="total" value="#{50 + 50}"/>
        <property name="length" value="#{100 - 10}"/>
        <property name="size" value="#{10 * 10}"/>
        <property name="reminder" value="#{10 % 3}"/>
        <property name="distance" value="#{1000 / 10}"/>
        <property name="power" value="#{2 ^ 10}"/>
    </bean>

</beans>
```

The configuration above requires a bean / pojo called MyBean. It's a simple class with some fields and getters and setters. Followed later by a simple class called SpELMathOperationDemo that demonstrate the Spring EL math operations.

```java
package org.kodejava.example.spring.el;

public class MyBean {
    private int total;
    private int length;
    private int size;
    private float distance;
    private int reminder;
    private int power;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
```

```java
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
```

And this are the output printed out by the code snippet:

```text
bean.getTotal()    = 100
bean.getLength()   = 90
bean.getSize()     = 100
bean.getReminder() = 1
bean.getDistance() = 100.0
bean.getPower()    = 1024
```
