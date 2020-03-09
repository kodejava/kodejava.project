# How do I call static method using Spring EL?

In this example you will learn how to call static method using Spring EL. The `T()` operator of the Spring EL can be use to call static method. First, create the following class, `NumberGenerator`. This class have a single property `randomNumber` and getter / setter method.

```java
package org.kodejava.example.spring.el;

public class NumberGenerator {
    private int randomNumber;

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
```

Now, create the following spring configuration file and save it in a file called `SpELStatic.xml`. In this configuration we register a bean called `bean` of type `NumberGenerator`. We set its `randomNumber` property using the value produced by the `java.lang.Math.random()` static method. For calling a static method we use the Spring EL `T()` operator, for example `#{T(java.lang.Math).random()}`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bean" class="org.kodejava.example.spring.el.NumberGenerator">
        <property name="randomNumber"
                  value="#{T(java.lang.Math).random() * 100 + 1}"/>
    </bean>
    
</beans>
```

The program below load the spring configuration and get the `NumberGenerator` bean to create a randon number.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticELDemo {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-static.xml");

        NumberGenerator number = (NumberGenerator) context.getBean("bean");
        System.out.println("Random number: " + number.getRandomNumber());
    }
}
```

And example result you might get when running the program:

```text
Random number: 33
```
