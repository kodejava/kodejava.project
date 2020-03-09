# How do I define inner bean in Spring?

Inner bean is a bean define inside another bean, it can be seen as an inner class. In another word the inner bean is a bean defined within the scope of another bean. In this case the inner bean can only be use by the outer bean. No other bean in the Spring context can refer to that bean.

So if you sure that a bean is only use within a single bean it is a good idea to use an inner bean instead. Inner bean can be injected through setter injection or constructor injection.

Here is an example of Spring configuration for an inner bean injection:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="racer" class="org.kodejava.example.spring.innerbean.Racer">
        <property name="car">
            <bean class="org.kodejava.example.spring.innerbean.Car">
                <property name="maker" value="Ferrari"/>
                <property name="year" value="2019"/>
            </bean>
        </property>
    </bean>

</beans>
```

In this configuration we use a setter injection. So we use the `property` element. Instead of using a `ref` attribute for referring to another bean we define the bean using the `bean` element inside the `property` element. And then we create the `Car` bean and sets its properties.

If you want to you a constructor injection you can inject the `Car` bean into the `Racer` bean by defining a bean inside of the `constructor-arg` element in the `Racer` bean.

Below is our `Racer` and `Car` classes.

```java
package org.kodejava.example.spring.innerbean;

public class Racer {
    private Car car;

    public Racer() {
    }

    public Racer(Car car) {
        this.car = car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Racer{" +
            "car=" + car +
            '}';
    }
}
```

```java
package org.kodejava.example.spring.innerbean;

public class Car {
    private String maker;
    private int year;

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
            "maker='" + maker + "'" +
            ", year=" + year +
            '}';
    }
}
```

Let's create our `Demo` class to run the program:

```java
package org.kodejava.example.spring.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"inner-bean.xml"});

        Racer racer = (Racer) context.getBean("racer");
        System.out.println("Racer = " + racer);
    }
}
```

Here is the output of our program:

```text
Racer = Racer{car=Car{maker='Ferrari', year=2019}}
```
