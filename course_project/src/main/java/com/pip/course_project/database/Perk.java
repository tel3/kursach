package com.pip.course_project.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "perks")
public class Perk {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    public Effect effect;

    public Integer levelreq;

    @ManyToOne
    @JoinColumn(name = "skills_id")
    public Skill skilltree;

}
