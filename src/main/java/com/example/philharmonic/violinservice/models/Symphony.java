package com.example.philharmonic.violinservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "symphonies")

public class Symphony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="composer")
    private String composer;

    @Column(name="opus")
    private int opus;

    @JsonIgnore
    @ManyToMany
    //NEW Cascade
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
           name = "violins_symphonies",
           joinColumns = {@JoinColumn(name = "symphony_id",
           nullable = false, updatable = false)
           },
           inverseJoinColumns = {@JoinColumn(name = "violin_id",
           nullable = false, updatable = false)
           })

    private List<Violin> violins;

    public Symphony(String composer, int opus) {
        this.composer = composer;
        this.opus = opus;
        this.violins  = new ArrayList();
    }

    public Symphony(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getOpus() {
        return opus;
    }

    public void setOpus(int opus) {
        this.opus = opus;
    }
//
//    public List<Violin> getViolins() {
//        return violins;
//    }
//
//    public void setViolins(List<Violin> violins) {
//        this.violins = violins;
//    }

    public void addViolin(Violin violin){
        this.violins.add(violin);
    }
}
