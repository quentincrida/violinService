package com.example.philharmonic.violinservice.models;

import javax.persistence.*;

@Entity
@Table(name="violins")

public class Violin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @ManyToOne
    @JoinColumn(name="tutti_id", nullable = false)
    private Tutti tutti;

    public Violin(String firstName, String lastName, int age, Tutti tutti) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.tutti = tutti;
    }
    public Violin(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tutti getTutti() {
        return tutti;
    }

    public void setTutti(Tutti tutti) {
        this.tutti = tutti;
    }
}
