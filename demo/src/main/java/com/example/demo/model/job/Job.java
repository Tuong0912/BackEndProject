package com.example.demo.model.job;

import com.example.demo.model.City;
import com.example.demo.model.Enterprise;
import com.example.demo.model.user.User;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Enterprise enterprise;
    private int numberRecruitments;
    private double salary;
    private LocalDate postDate;
    private LocalDate expriteDate;
    private String experience;
    private String content;
    private String shortDescription;
    private String longDescription;
    private String src;
    private Boolean status = false;
    @ManyToOne
    private Qualification qualification;
    @ManyToOne
    private ProgramingLanguage programingLanguage;
    @ManyToOne
    @Lazy
    private City city;


    public Job() {
    }

    public Job(Long id, Enterprise enterprise, int numberRecruitments, double salary, LocalDate postDate, LocalDate expriteDate, String experience, String content, String shortDescription, String longDescription, String src, Boolean status, Qualification qualification, ProgramingLanguage programingLanguage, City city) {
        this.id = id;
        this.enterprise = enterprise;
        this.numberRecruitments = numberRecruitments;
        this.salary = salary;
        this.postDate = postDate;
        this.expriteDate = expriteDate;
        this.experience = experience;
        this.content = content;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public LocalDate getExpriteDate() {
        return expriteDate;
    }

    public void setExpriteDate(LocalDate expriteDate) {
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
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

    public int getNumberRecruitments() {
        return numberRecruitments;
    }

    public void setNumberRecruitments(int numberRecruitments) {
        this.numberRecruitments = numberRecruitments;
    }

}
