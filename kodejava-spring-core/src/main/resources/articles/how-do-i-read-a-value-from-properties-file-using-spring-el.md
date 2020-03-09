# How do I read a value from properties file using Spring EL?

In the previous two examples you have seen how to [access member of a collection](//kodejava.org/how-do-i-access-collections-members-using-spring-el/) and [access a map element](//kodejava.org/how-do-i-access-map-element-using-spring-el/) using the square-braces `[]` operator in Spring EL. In this example you will see how to use the `[]` operator to read a value from a properties file or `java.util.Properties`. 

Let’s say we have a database properties file called `database.properties` with the following entries in it:

```text
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost/kodejava
jdbc.username=root
jdbc.password=secret
```

First, let’s create the spring configuration file. In this configuration we will use the `<util:properties>` to load the properties configuration into Spring. And then we will use Spring EL to access the value of this properties and assign it to some bean’s properties.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <util:properties id="database" location="classpath:database.properties"/>

    <bean id="dataSource" class="org.kodejava.example.spring.model.MyDataSource">
        <property name="driverClassName" value="#{database['jdbc.driverClassName']}"/>
        <property name="url" value="#{database['jdbc.url']}"/>
        <property name="username" value="#{database['jdbc.username']}"/>
        <property name="password" value="#{database['jdbc.password']}"/>
    </bean>
</beans>
```

To read a value from properties file what you do is the same as how we access an element of a map object. We pass the name of the properties as the key in the Spring EL.

```xml
<property name="driverClassName" value="#{database['jdbc.driverClassName']}"/>
```

The `MyDataSource` class is an imaginary data source object. It has some properties such as the `driverClassName`, `url`, `username` and `password`. It’s a common parameter you use to connect to a database using a JDBC driver. For simplicity the getters and setters we removed from the class.

```java
package org.kodejava.example.spring.el;

public class MyDataSource {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    // Getters & Setters
}
```

As always, to run the Spring configuration above we will need to create a main class that load and execute the application context. This class will obtain the dataSource bean from the application context and print out its properties whose values are read from a properties file called database.properties.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELPropertiesExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-properties.xml");

        MyDataSource dataSource = (MyDataSource) context.getBean("dataSource");
        System.out.println("driverClassName = " + dataSource.getDriverClassName());
        System.out.println("url             = " + dataSource.getUrl());
        System.out.println("username        = " + dataSource.getUsername());
        System.out.println("password        = " + dataSource.getPassword());
    }
}
```

Here are the result you get when running the code snippet:

```text
driverClassName = com.mysql.jdbc.Driver
url             = jdbc:mysql://localhost/kodejava
username        = root
password        = secret
```
