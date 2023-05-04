package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JsonIgnore
    private Enterprise enterprise;
    @ManyToOne
    @JsonIgnore
    private Job job;



    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public City(Long id, String name, Enterprise enterprise, Job job) {
        this.id = id;
        this.name = name;
        this.enterprise = enterprise;
        this.job = job;
    }

    public City() {
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }


}
