# How do I initialize and destroy beans in Spring?

When creating an instance of a bean you might need to do some initialization to the bean. Likewise, when the bean is no longer needed and removed from the Spring container you might want to do some cleanup routine or destroy the bean.

To do this initialization and destroy routine you can use the `init-method` and `destroy-method` attribute when declaring a bean in spring configuration using the `<bean>` element.

By defining the `init-method` and `destroy-method` it will allow the Spring Container to call the initialization method right after the bean created. And just before the bean removed and discarded from the container, the defined destroy method will be called. Let's see some code snippet as an example.

```java
package org.kodejava.example.spring.init;

public class AutoEngine {
    public void initialize() {
        System.out.println("AutoEngine.initialize");
    }

    public void destroy() {
        System.out.println("AutoEngine.destroy");
    }
}
```

Below is the Spring configuration file that we use to declare the bean. You'll see in the configuration there are additional attributes that we add to the bean.


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="engine" class="org.kodejava.example.spring.init.AutoEngine"
          init-method="initialize" destroy-method="destroy"/>
    
</beans>
```

Create a small program to execute our demo:

```java
package org.kodejava.example.spring.init;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroyDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("init-destroy.xml");

        AutoEngine engine = (AutoEngine) context.getBean("engine");

        // context.close will remove the bean from the container. 
        // This will call our bean destroy method.
        context.close();
    }
}
```

When you run the program it will print the following output:

```text
AutoEngine.initialize
AutoEngine.destroy
```

The advantage of using this method to initialize or clean up the bean is that it does not mandate our bean to implement or extend any Spring API which will make our bean reusable on other container beside Spring.
