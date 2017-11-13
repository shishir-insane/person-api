package com.sk.wagawin.person.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Person {
    public static final String PERSON_ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int age;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private Set<Child> children;
    
    @OneToOne(mappedBy = "person")
    @JsonManagedReference
    private House house;
}
