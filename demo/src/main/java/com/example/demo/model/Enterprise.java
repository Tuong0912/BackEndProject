package com.example.demo.model;

import com.example.demo.model.user.User;

import javax.persistence.*;

@Entity
@Table
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String gmail;
    private String phoneNumber;
    private String avatar;
    private Boolean status = false;
    @OneToOne(mappedBy = "enterprise")
    private User user;

    @ManyToOne
    private City city;

    public Enterprise(Long id, String name, String address, String gmail, String phoneNumber, String avatar, Boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.status = status;
    }

    public Enterprise(String gmail) {
        this.gmail = gmail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Enterprise() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
