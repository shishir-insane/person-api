package com.sk.wagawin.person.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Child {
    public static final String ID = "id";
    public static final String FK_PERSON_ID = "fk_child_person_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = Person.PERSON_ID, insertable = false, updatable = false)
    @JsonBackReference
    private Person parent;

    private String name;

    private boolean isDaughter;

    private String color;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Meal> meals;
}
