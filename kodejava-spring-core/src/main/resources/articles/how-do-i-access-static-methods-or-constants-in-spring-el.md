# How do I access static methods or constants in Spring EL?

In this examples you will learn how to access class-scoped methods or constants using Spring Expression Language. To access a class-scoped methods or constants you will need to use the `T()` operator of the Spring EL, for example `T(java.lang.Math)`. This operator will give us the access to static methods and constants on a given class. As an example we can access the `Math.PI` in Spring EL like `T(java.lang.Math).PI`.

Just like accessing the static constants we can also access a static method in the same way. For example we can call the `Math.random()` method in Spring EL like this `T(java.lang.Math).random()`.

Now let's see how we do these inside a spring configuration file. In this configuration we create a bean called `myBean` that have properties such as `randomNumber`, `pi` and `name`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="org.kodejava.example.spring.el.MyOtherBean">
        <property name="randomNumber" value="#{T(java.lang.Math).random()}"/>
        <property name="pi" value="#{T(java.lang.Math).PI}"/>
        <property name="name" value="#{T(org.kodejava.example.spring.el.MyOtherBean).BEAN_NAME}"/>
    </bean>

</beans>
```

Here are out bean class and an application class that run the spring configuration for the demo.

```java
package org.kodejava.example.spring.el;

public class MyOtherBean {
    public static final String BEAN_NAME = "MyOtherBean";

    private String randomNumber;
    private String pi;
    private String name;

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getPi() {
        return pi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

```java
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
```

When executing the program you will get the following result as the output:

```text
bean.getRandomNumber() = 0.7173165965231882
bean.getPi()           = 3.141592653589793
bean.getName()         = MyOtherBean
```
