# How do I use InitializingBean and DisposableBean interfaces in Spring?

In the other example, [How do I initialize and destroy beans in Spring?](//kodejava.org/how-do-i-initialize-and-destroy-beans-in-spring/) you can see how to initializing and destroying a bean using the Spring configuration `init-method` and `destroy-method`.

In the following example you'll see how to achieve the same thing using the Spring API. In this case our class need to implements the `InitializingBean` and `DisposableBean`. These interfaces is located under the `org.springframework.beans.factory` package.

The `InitializingBean` interface requires us to implements the `afterPropertiesSet()` method. This method will be the init method of our bean. The `destroy()` method which is a contract defined in the `DisposableBean` interface is where we'll place the clean-up logic of our bean.

The drawback of using this approach is that our classes will be required to use the Spring API. If you want to use the class outside the Spring container using the other approach mentioned above is a better way to go.

Now, let's see some code in action.

```java
package org.kodejava.example.spring.destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InitDisposeService implements InitializingBean, DisposableBean {

    /**
     * Do some processes.
     */
    public void doSomething() {
        System.out.println("InitDisposeService.doSomething");
    }

    /**
     * Initialize bean after property set.
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitDisposeService.afterPropertiesSet");
    }

    /**
     * Clean-up bean when the context is closed.
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("InitDisposeService.destroy");
    }
}
```

As usual, we define our Spring configuration (`init-dispose.xml`) to register our bean. In this case we will create a bean with id called `service` and will be using the `InitDisposeService` class.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="service" class="org.kodejava.example.spring.destroy.InitDisposeService"/>

</beans>
```

Below is a small Java program that we can use to run our application. This will load the Spring configuration, get the bean from the container and execute the bean. We'll see that the `afterPropertiesSet` method is called. And when the context is closed the `destroy` method is also executed.

```java
package org.kodejava.example.spring.destroy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDisposeDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
            new ClassPathXmlApplicationContext("init-dispose.xml");

        InitDisposeService service =
            (InitDisposeService) context.getBean("service");
        service.doSomething();

        context.close();
    }
}
```

Here are the output printed on the screen:

```text
InitDisposeService.afterPropertiesSet
InitDisposeService.doSomething
InitDisposeService.destroy
```
