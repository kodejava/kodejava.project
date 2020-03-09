# How do I define bean scoping in Spring?

Bean scoping is how the bean is created and returned from the spring container to the bean requester. By default the scope of all bean is singleton. The spring container will always return the same bean whenever this bean is required, for instance when in injected or call using the `getBean()` method from the application context.

There are five types of bean scope define in the Spring Container:

| Scope | Description |
|:---|:---|
| `singleton` | Scope the bean definition to a single bean instance per Spring Container. This is the default scope when no scope is defined when creating a bean. |
| `prototype` | Scope the bean to allow multiple times bean creation. This will create a new bean for each time the bean is required. |
| `request` | Scope the bean definition to a single HTTP request. <sup>*</sup> |
| `session` | Scope the bean definition to a single HTTP session. <sup>*</sup> |
| `global-session` | Scope the bean definition to a global HTTP session. <sup>*</sup> |

_*) This is only valid when using the web-capable Spring context._

Let's see the difference between `Singleton` and `Prototype` scope. First we'll create our `DummyService` class.

```java
package org.kodejava.example.spring.dummy;

public class DummyService {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
```

#### Singleton Scope

By default when no scope defined it will be a singleton.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="service" class="org.kodejava.example.spring.dummy.DummyService"/>

</beans>
```

Now create a program to run our example. First will run it using the `singleton.xml` as the configuration.

```java
package org.kodejava.example.spring.dummy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("singleton.xml");

        DummyService serviceA =
            (DummyService) context.getBean("service");
        serviceA.setMessage("Hello From A");
        System.out.println("Message A = " + serviceA.getMessage());

        DummyService serviceB =
            (DummyService) context.getBean("service");
        System.out.println("Message B = " + serviceB.getMessage());
    }
}
```

The output of the singleton configuration is:

```text
Message A = Hello From A
Message B = Hello From A
```

The above output show that the message printed by the `serviceB` is the same as the `serviceA`. We don't even set the message in the `serviceB` explicitly. It print the same message because the `getBean()` method actually return the same bean both for `serviceA` and `serviceB`. This is the singleton scope.

#### Prototype Scope

To change the scope to prototype use the `scope` attribute in the bean element as shown below.


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="service" class="org.kodejava.example.spring.dummy.DummyService"
          scope="prototype"/>

</beans>
```

```java
package org.kodejava.example.spring.dummy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopePrototypeDemo {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("prototype.xml");

        DummyService serviceA =
            (DummyService) context.getBean("service");
        serviceA.setMessage("Hello From A");
        System.out.println("Message A = " + serviceA.getMessage());

        DummyService serviceB =
            (DummyService) context.getBean("service");
        System.out.println("Message B = " + serviceB.getMessage());
    }
}
```

Now if you try to run the same program again but changing the configuration to `prototype.xml` you'll get the following output printed:

```text
Message A = Hello From A
Message B = null
```

The `serviceB` now print a different message. This is the effect of using the `prototype` scope. When we call the `getBean()` a new bean will be created per request.
