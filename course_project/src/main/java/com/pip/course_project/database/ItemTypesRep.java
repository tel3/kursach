package com.pip.course_project.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface ItemTypesRep extends CrudRepository<ItemTypes, Long> {
}
