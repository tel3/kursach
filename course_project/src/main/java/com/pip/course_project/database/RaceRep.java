package com.pip.course_project.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRep extends CrudRepository<Race, Long> {
}
