package com.example.philharmonic.violinservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="first_violins")

public class FirstViolins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_violins")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "firstViolins")
    private List<Violin> firstViolins;

    public FirstViolins(String name) {
        this.name = name;
        this.firstViolins = new ArrayList<Violin>();
    }
    public FirstViolins(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Violin> getFirstViolins() {
        return firstViolins;
    }

    public void setFirstViolins(List<Violin> firstViolins) {
        this.firstViolins = firstViolins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
