package com.pip.course_project.database;


import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    public Character gender;

    @ManyToOne
    @JoinColumn(name = "races_id")
    public Race race;

    @ManyToOne
    @JoinColumn(name = "factions_id")
    public Faction faction;

//    @ManyToOne
//    @JoinColumn(name = "class_id")
//    public Class aclass;

    public Boolean hostility;

    public Boolean interactivity;

    public Boolean uniqueness;

}
