package com.sk.wagawin.person.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Child.ID, insertable = false, updatable = false)
    private Child child;
    
    private String name;
    
    @Temporal(TemporalType.DATE)
    private Date invented;
}
