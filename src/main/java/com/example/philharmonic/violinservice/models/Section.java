package com.example.philharmonic.violinservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sections")

public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "section")
    private List<Violin> sections;

    public Section(String name) {
        this.name = name;
        this.sections = new ArrayList<Violin>();
    }
    public Section(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Violin> getFirstViolins() {
        return sections;
    }

    public void setFirstViolins(List<Violin> firsts) {
        this.sections = sections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
