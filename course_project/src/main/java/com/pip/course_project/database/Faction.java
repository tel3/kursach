package com.pip.course_project.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "factions")
public class Faction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "locations_id")
    public Location location;

    @ManyToOne
    @JoinColumn(name = "actors_id")
    public Actor initialleader;

}
