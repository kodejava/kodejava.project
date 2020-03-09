# How do I do pattern matching using regular expression in Spring EL?

In this Spring Expression Language example we are going to learn how to use regular expression or regex to check if a text matches a certain pattern. Spring EL support regular expression using the `matches` operator.

The `matches` operator will check if the value has a pattern defined by the regex string and it returns the evaluation result as a boolean value `true` if the text matches the regex or `false` if otherwise.

For example we can use the `matches` operator to check is a the given email address is a valid email address. As can be seen in the following example:

```xml
<property name="emailValid" 
          value="#{user.email matches '^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$'}"/>
```

This configuration will evaluate the `user.email` property to check if the email pattern matches with the given regular expression. If matches then the `emailValid` property will be set to `true` otherwise it will be `false`.

Let's see the complete example. Here are the spring configuration file, the `User` bean and a simple class for running the configuration file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="user" class="org.kodejava.example.spring.el.User">
        <constructor-arg name="email" value="kodejava@gmail.com"/>
        <property name="emailValid"
                  value="#{user.email matches '^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$'}"/>
    </bean>

    <bean id="user2" class="org.kodejava.example.spring.el.User">
        <constructor-arg name="email" value="kodejava.at.gmail.dot.com"/>
        <property name="emailValid"
                  value="#{user2.email matches '^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$'}"/>
    </bean>

</beans>
```

The `User` bean is a simple pojo with two properties, a string `email` property and a boolean `validEmail` property.

```java
package org.kodejava.example.spring.el;

public class User {
    private String email;
    private boolean emailValid;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailValid() {
        return emailValid;
    }

    public void setEmailValid(boolean emailValid) {
        this.emailValid = emailValid;
    }
}
```

And finally the application class.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELRegexExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-regex.xml");

        User user = (User) context.getBean("user");
        System.out.println("user.getEmail()     = " + user.getEmail());
        System.out.println("user.isEmailValid() = " + user.isEmailValid());

        User user2 = (User) context.getBean("user2");
        System.out.println("user.getEmail()     = " + user2.getEmail());
        System.out.println("user.isEmailValid() = " + user2.isEmailValid());
    }
}
```

When we run the code we will obtain the following result:

```text
user.getEmail()     = kodejava@gmail.com
user.isEmailValid() = true
user.getEmail()     = kodejava.at.gmail.dot.com
user.isEmailValid() = false
```
