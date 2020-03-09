# How do I read system environment variables in Spring EL?

Previously you have seen that we can load properties file and read a value from it in this example: [How do I read a value from properties file using Spring EL?](//kodejava.org/how-do-i-read-a-value-from-properties-file-using-spring-el/). In this example you will learn how to read a special properties available to Spring EL. These properties includes the `systemEnvironment` and `systemProperties`.

The `systemEnvironment` property contains all the environment variables on the machine where the program is running. Meanwhile, the `systemProperties` contains all the properties that we set in Java when the application started, using the `-D` argument. Let’s see how to access both of these properties in the following Spring configuration file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="program1" class="org.kodejava.example.spring.el.Program">
        <property name="logPath" value="#{systemProperties['APP.LOG_PATH']}"/>
    </bean>

    <bean id="program2" class="org.kodejava.example.spring.el.Program">
        <property name="logPath" value="#{systemEnvironment['HOME']}"/>
    </bean>

</beans>
```

In the configuration above we have two beans of `Program`. We set the `logPath` properties using a different property source. In the `program1` bean we use `systemProperties['APP.LOG_PATH']`. Using this method the value will be pass to our program using the `-DAPP.LOG_PATH=/Users/wayan/tmp` when we are executing the program. While the `program2` bean’s `logPath` is read from user’s home directory property available through the `systemEnvironment` variables.

To make the Spring configuration works you’ll need the `Program` class. So here is the class definition.

```java
package org.kodejava.example.spring.el;

public class Program {
    private String logPath;

    public Program() {
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
}
```

Finally, let’s create a simple class to execute the Spring configuration file above and see the result of the code.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELEnvironment {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-environment.xml");

        Program program1 = (Program) context.getBean("program1");
        System.out.println("program.getLogPath() = " + program1.getLogPath());

        Program program2 = (Program) context.getBean("program2");
        System.out.println("program.getLogPath() = " + program2.getLogPath());
    }
}
```

The code will print the following result:

```text
program.getLogPath() = /Users/wayan/tmp
program.getLogPath() = /Users/wayan
```
