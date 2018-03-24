package com.pip.course_project.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

}
