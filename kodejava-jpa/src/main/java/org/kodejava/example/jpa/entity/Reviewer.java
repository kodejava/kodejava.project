package org.kodejava.example.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reviewers")
public class Reviewer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
