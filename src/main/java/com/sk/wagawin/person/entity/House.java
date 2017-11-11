package com.sk.wagawin.person.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class House {
    public static final String ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Person.ID, insertable = false, updatable = false)
    private Person parent;

    private String name;

    private boolean isDaughter;

    private String color;

    @OneToMany(mappedBy="child")
    private Set<Meal> meals;
}
