package org.kodejava.example.commons.lang;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

public class Book implements Serializable {
    private Long id;
    private String title;
    private String author;

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    //~ Implements getters and setters here.

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Book)) {
            return false;
        }

        Book that = (Book) o;
        return new EqualsBuilder()
            .append(this.id, that.id)
            .append(this.title, that.title)
            .append(this.author, that.author)
            .isEquals();

        // You can also use reflection of the EqualsBuilder class.
        // return EqualsBuilder.reflectionEquals(this, that);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(id)
            .append(title)
            .append(author)
            .toHashCode();

        // Or even use the simplest method using reflection
        // below.
        // return HashCodeBuilder.reflectionHashCode(this);
    }
}
