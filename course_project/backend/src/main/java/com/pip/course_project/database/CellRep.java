package com.pip.course_project.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellRep extends CrudRepository<Cell, Long> {
}
