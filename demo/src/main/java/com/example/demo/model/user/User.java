package com.example.demo.model.user;

import com.example.demo.model.Enterprise;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 6, max = 50)
    private String fullname;


    @Size(min = 6, max = 32)
    private String username;

    @NotNull
    @Size(min = 6, max = 8)
    private String password;

    @Size(max = 50)
    private String email;

    @Size(min = 10, max = 15)
    private String phone;

    private String address;
    private boolean aBoolean;
    @OneToOne(mappedBy = "user")
    private Enterprise enterprise;
    @ManyToOne
    private Role role;

    public User() {
    }

    public User(Long id, String fullname, String username, String password, String email, String phone, String address, boolean aBoolean, Role roles, Enterprise enterprise) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.aBoolean = aBoolean;
        this.role = roles;
        this.enterprise = enterprise;
    }

    public User(
            @NotBlank
            @Size(min = 6, max = 50) String fullname,
            @NotBlank
            @Size(min = 6, max = 32) String username,
            @NotBlank
            @Size(min = 6, max = 8) String password,
            @Size(max = 50) String email,
            @Size(min = 10, max = 15) String phone,
            String address,
            Role roles,
            Enterprise enterprise
    ) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = roles;
        this.enterprise = enterprise;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}

