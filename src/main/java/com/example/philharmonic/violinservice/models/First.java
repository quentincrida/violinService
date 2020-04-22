package com.example.philharmonic.violinservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="firsts")

public class First {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "first")
    private List<Violin> firsts;

    public First(String name) {
        this.name = name;
        this.firsts = new ArrayList<Violin>();
    }
    public First(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Violin> getFirstViolins() {
        return firsts;
    }

    public void setFirstViolins(List<Violin> firsts) {
        this.firsts = firsts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
