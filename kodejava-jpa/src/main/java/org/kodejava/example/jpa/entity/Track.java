package org.kodejava.example.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tracks")
public class Track implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Record record;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
