# How do I define access modifier in Lombok's Getter and Setter annotations?

By default when we use the Lombok's `@Getter` and `@Setter` annotations the getters and setters will be created with `public` access modifier. We can however change the access modifier by setting the `AccessLevel` of the `@Getter` and `@Setter` annotations. The available choices for the access level are `AccessLevel.PUBLIC`, `AccessLevel.PROTECTED`, `AccessLevel.PACKAGE`, `AccessLevel.PRIVATE`. These enum values correspond to Java's access modifier. While the `AccessLevel.NONE` will disable the getter and setter method generation. 

```java
package org.kodejava.example.lombok.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {
    @Setter(AccessLevel.PROTECTED)
    private String firstName;

    private String lastName;
    private String gender;

    @Getter(AccessLevel.PRIVATE)
    private int age;
}
```

How we use the `Person` class show in the snippet below:

```java
package org.kodejava.example.lombok;

import org.kodejava.example.lombok.domain.Person;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setLastName("Bar");
        person.setGender("M");
        person.setAge(20);

        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        System.out.println(person.getGender());
    }
}
```

If we try to see the generated class of the `Person` class we can run the following command to disassemble the class.

```text
javap -p -cp . org.kodejava.example.lombok.domain.Person
```

And we got the following output of the `javap` command. As we can see that the `setFirstName()` method have a `protected` access modifier and the `getAge()` method have a `private` access modifier. The other mutator and accessor method all set to `public` access modifier.

```java
public class org.kodejava.example.lombok.domain.Person {
  private java.lang.String firstName;
  private java.lang.String lastName;
  private java.lang.String gender;
  private int age;
  public org.kodejava.example.lombok.domain.Person();
  public java.lang.String getFirstName();
  public java.lang.String getLastName();
  public java.lang.String getGender();
  public void setLastName(java.lang.String);
  public void setGender(java.lang.String);
  public void setAge(int);
  protected void setFirstName(java.lang.String);
  private int getAge();
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
