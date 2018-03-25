package com.pip.course_project.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    public Effect effect;
}
