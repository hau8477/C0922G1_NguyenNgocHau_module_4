package com.example.model.login;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity

public class AppRole {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 255)
    @NotNull
    @Column(columnDefinition = "varchar(255)", unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "roleSet")
    @JsonBackReference
    private Set<AppUser> userSet;
    private boolean flag;

    public AppRole() {
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Set<AppUser> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<AppUser> userSet) {
        this.userSet = userSet;
    }

}