# How do I defaulting init-method and destroy method in Spring?

When many beans in a context definition will have the same initialization and destroy method name, you can define a `default-init-method` and `default-destroy-method` in the attributes of the `beans` element.

This way you don't have to define individual `init-method` and `destroy-method` for each of your beans. When the beans does not supply the method that match the name of defined `default-init-method` or `default-destroy-method` nothing will happen to those beans.

Let's see an example code below. Firs here is our simple bean, the `AutoEngine` bean.

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

And then we define our Spring configuration file. You can see that there are `default-init-method` and `default-destroy-method` in the attribute of the `beans` element.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
       default-init-method="initialize" default-destroy-method="destroy">

    <bean id="engine" class="org.kodejava.example.spring.init.AutoEngine"/>

</beans>
```

And finally a small program to run our demo.

```java
package org.kodejava.example.spring.init;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultInitDestroyDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("default-init-destroy.xml");

        AutoEngine engine = (AutoEngine) context.getBean("engine");

        // context.close will remove the bean from the container.
        // This will call our bean destroy method.
        context.close();
    }
}
```

When you run this example you'll get the following output printed on your screen:

```text
AutoEngine.initialize
AutoEngine.destroy
```
