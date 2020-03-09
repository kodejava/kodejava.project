# How do I declare a bean in Spring application?

In this example we will learn how to declare a bean in Spring Application. We are going to build a simple Maven project to demonstrate it. So let's begin by setting up our Maven project.

### Creating a Maven Project

Below is the directory structure of our Maven Project.

```text
.
├── pom.xml
└── src
    └── main
        ├── java
        │   └── org
        │       └── kodejava
        │           └── example
        │               └── spring
        │                   └── hello
        │                       ├── Hello.java
        │                       ├── HelloImpl.java
        │                       └── HelloWorldDemo.java
        └── resources
            └── spring.xml
```

### Configure Mavem `pom.xml` File

We need to create a `pom.xml` file and add our project configuration and library dependency.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>kodejava-project</artifactId>
        <groupId>org.kodejava.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>kodejava-spring-core</artifactId>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.1.2.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>5.1.2.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>5.1.2.RELEASE</version>
        </dependency>
    </dependencies>
</project>
```

### Creating a Spring Bean

Next we will create a simple bean called `HelloImpl`. This bean implements an interface called `Hello` with a single method `sayHello()` to be implemented. Here is the interface it's implementation definition.

```java
package org.kodejava.example.spring.hello;

public interface Hello {
    void sayHello();
}
```

```java
package org.kodejava.example.spring.hello;

public class HelloImpl implements Hello {

    public void sayHello() {
        System.out.println("Hello World!");
    }
}
```

### Register the Bean in Spring Configuration 

After having the bean we need to create the Spring configuration, which is an xml file, we name it `spring.xml`. The bean declared using the `bean` element in the configuration file. At minimum the declaration contains the bean's `id` and it's `class`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
       
    <bean id="hello" class="org.kodejava.example.spring.hello.HelloImpl"/>
    
</beans>
```

### Use the Bean in Our Application

Now we have the bean declared in the Spring container. The next step show you how to get the bean from the container and use it in our program. There are many ways that can be use to load the Spring container. Here we will use the `ClassPathXmlApplicationContext`. This class load the configuration that found in the runtime classpath.

```java
package org.kodejava.example.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldDemo {
    public static void main(String[] args) {
        String config = "spring.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        Hello hello = (Hello) context.getBean("hello");
        hello.sayHello();
    }
}
```
