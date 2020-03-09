# How do I create beans through factory method?

This example show you how to create a bean using factory method in Spring Framework. We will use a singleton as an example. An instance of a singleton can be obtained only from a factory method because a singleton will have a private constructor so it will not possible to create an instance of this class from outside the singleton itself.

Here is our singleton bean will look like. To get an instance of it we well need to call the `getInstance()` method.

```java
package org.kodejava.example.spring.factory;

public class Singleton {

    /**
     * Private constructor.
     */
    private Singleton() {
    }

    private static class SingletonHolder {
        static Singleton instance = new Singleton();
    }

    /**
     * Get an instance of Singleton class.
     * @return an instance of Singleton class.
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * Do something.
     */
    public void doSomething() {
        System.out.println("Singleton.doSomething");
    }
}
```

Next, we will create a spring configuration file. At it simplest a bean in the configuration file will have an `id` and a `class`. To tell the spring container to create the bean using a factory method we must use the `factory-method` attribute of the bean element.

Here is our configuration file and we name it `factory-method.xml`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="singleton" class="org.kodejava.example.spring.factory.Singleton"
          factory-method="getInstance">
    </bean>

</beans>
```

Let's now run our program below:

```java
package org.kodejava.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("factory-method.xml");

        Singleton instance =
                (Singleton) context.getBean("singleton");
        instance.doSomething();
    }
}
```
