package com.sk.wagawin.person.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sk.wagawin.person.util.HouseType;

import lombok.Data;

@Data
@Entity
public class House {
    public static final String HOUSE_ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Person.PERSON_ID, insertable = false, updatable = false)
    @JsonBackReference
    private Person person;

    private String address;

    private String zipCode;

    @Enumerated(EnumType.STRING)
    private HouseType type;

    @JsonIgnore
    public String getHouseType() {
        return type.toString();
    }
}
