# What is JPA (Java Persistence API)?

JPA is a Java specification for object-relational mapping (ORM) in Java. JPA provide a way to map Java objects to database tables. This allows programmers to manipulate database information directly using Java objects instead of executing database SQL queries.

Developer can choose one of many available JPA specification implementation libraries such as [Hibernate](http://hibernate.org/), [Apache OpenJPA](http://openjpa.apache.org/) and [EclipseLink](https://www.eclipse.org/eclipselink/). EclipseLink is the reference implementation of the JPA specification. In the examples that we are going to provide you in this website, Hibernate library will be used as the persistence provider.

In JPA we model our database tables into a Java objects. This Java objects also called as `entity` objects. The entity represent a table in database. A single row in a database table will be represented in an instance of the entity. This entity objects hold information about the mapping between objects and database tables. This information or metadata can be defined using an annotation or an XML mapping files.

Here is a simple example of entity object and its metadata information.

```java
package org.kodejava.example.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "genres")
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Genre() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id) &&
            Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Genre{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
```

In the sample entity above we use annotation such as `@Entity`, `@Table`, `@Id`, `@GeneratedValue` and `@Column`. These are some annotations that you can use for object mapping.

Besides manipulating database tables using objects, JPA also provide a SQL-like queries that can be use to create a static or dynamic query statement.

**Maven Dependencies**

```xml
<!-- https://search.maven.org/remotecontent?filepath=javax/persistence/javax.persistence-api/2.2/javax.persistence-api-2.2.jar -->
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>
```

[![Maven Central](https://img.shields.io/maven-central/v/javax.persistence/javax.persistence-api.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22javax.persistence%22%20AND%20a:%22javax.persistence-api%22)
