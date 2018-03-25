package com.pip.course_project.database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "itemtypes")
public class ItemType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

}
