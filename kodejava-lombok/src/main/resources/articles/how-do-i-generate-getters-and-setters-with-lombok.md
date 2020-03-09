# How do I generate Getters and Setters with Lombok? 

The following code snippet show you how to use [Project Lombok](https://projectlombok.org/)'s `@Getter` and `@Setter` annotations to generate getters and setters method in your POJO _(plain old java objects)_ classes. Using these annotations remove the need to manually implements the mutator and accessor methods. Although most IDE allows you the generate these methods, using Lombok makes your classes look cleaner, especially when you have a long list of fields.

Here is a simple `User` class with a handful fields. We will use the `@Getter` and `@Setter` annotations on the class level. This will generate the getters and setters method for any non-static fields in the class.

```java
package org.kodejava.example.lombok.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private LocalDate lastLogin;
    private boolean active;
}
```

Each fields in the class will have its corresponding getter and setter. For example the `username` field will have the `getUsername()` and `setUsername()` method. If the field type is `boolean` such as `active` it will generate the method `setActive()` and `isActive()` method.

Because the accessor and mutator already handled by Lombok, we can use the `User` class as if we manually implements the getters and setters method.

```java
package org.kodejava.example.lombok;

import org.kodejava.example.lombok.domain.User;

import java.time.LocalDate;

public class UserDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("foo");
        user.setPassword("secret");
        user.setLastLogin(LocalDate.now());
        user.setActive(true);

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getLastLogin());
        System.out.println(user.isActive());
    }
}
```

If for some reasons you want to disable the getter and setter on specific field, or you want the change the access level, you can use the `AccessLevel` enums value for the `@Getter` and `@Setter` annotations. For example in the code snippet below the `username` will have no getter and setter while the `lastLogin` getter and setter will have `protected` access modifier. The `AccessLevel` enums includes `PUBLIC`, `MODULE`, `PROTECTED`, `PACKAGE`, `PRIVATE` and `NONE`.

```java
package org.kodejava.example.lombok.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Long id;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String username;
    private String password;
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private LocalDate lastLogin;
    private boolean active;
}
```

**Maven Dependencies**

```xml
<!--https://search.maven.org/remotecontent?filepath=org/projectlombok/lombok/1.18.4/lombok-1.18.4.jar-->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.4</version>
</dependency>
```

[![Maven Central](https://img.shields.io/maven-central/v/org.projectlombok/lombok.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.projectlombok%22%20AND%20a:%22lombok%22)
