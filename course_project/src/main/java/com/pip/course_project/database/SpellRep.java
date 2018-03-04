package com.pip.course_project.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRep extends CrudRepository<Spell, Long> {
}
