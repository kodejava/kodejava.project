package org.kodejava.example.hibernate.model;

import java.util.Date;
import java.util.Objects;

public class Label {
    private Long id;
    private String name;
    private Date created;
    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) &&
            Objects.equals(name, label.name) &&
            Objects.equals(created, label.created) &&
            Objects.equals(modified, label.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created, modified);
    }

    @Override
    public String toString() {
        return "Label{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", created=" + created +
            ", modified=" + modified +
            '}';
    }
}
