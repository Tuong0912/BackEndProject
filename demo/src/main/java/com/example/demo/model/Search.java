package com.example.demo.model;

public class Search {
    private Long id;
    private double minSalary;
    private double maxSalary;
    private String qualification;
    private String city;


    public Search(Long id, double minSalary, double maxSalary, String qualification, String city) {
        this.id = id;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.qualification = qualification;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
