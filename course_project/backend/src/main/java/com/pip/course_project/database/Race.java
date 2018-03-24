package com.pip.course_project.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

}
