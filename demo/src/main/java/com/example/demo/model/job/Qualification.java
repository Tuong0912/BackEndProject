package com.example.demo.model.job;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Qualification(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Qualification(String name) {
        this.name = name;
    }

    public Qualification() {
    }

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
}
