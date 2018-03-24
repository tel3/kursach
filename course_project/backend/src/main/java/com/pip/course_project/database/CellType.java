package com.pip.course_project.database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "celltypes")
public class CellType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

}
