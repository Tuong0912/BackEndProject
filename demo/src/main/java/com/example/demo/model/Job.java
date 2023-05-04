package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Enterprise enterprise;
    private String name;
    @ManyToOne
    private Salary Salary;
    private LocalDate postDate;
    private Date expriteDate;
    private String experience;
    private String content;
    @ManyToOne
    private Description description;

    private String src;
    private Boolean status = false;
    @ManyToOne
    private Qualification qualification;
    @ManyToOne
    @JsonIgnore
    private ProgramingLanguage programingLanguage;
    @ManyToOne
    @Lazy
    private City city;

    public Job() {
    }

    public Job(Long id, Enterprise enterprise, String name, com.example.demo.model.Salary salary, LocalDate postDate, Date expriteDate, String experience, String content, Description description, String src, Boolean status, Qualification qualification, ProgramingLanguage programingLanguage, City city) {
        this.id = id;
        this.enterprise = enterprise;
        this.name = name;
        Salary = salary;
        this.postDate = postDate;
        this.expriteDate = expriteDate;
        this.experience = experience;
        this.content = content;
        this.description = description;
        this.src = src;
        this.status = status;
        this.qualification = qualification;
        this.programingLanguage = programingLanguage;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.demo.model.Salary getSalary() {
        return Salary;
    }

    public void setSalary(com.example.demo.model.Salary salary) {
        Salary = salary;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public Date getExpriteDate() {
        return expriteDate;
    }

    public void setExpriteDate(Date expriteDate) {
        this.expriteDate = expriteDate;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public ProgramingLanguage getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(ProgramingLanguage programingLanguage) {
        this.programingLanguage = programingLanguage;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
