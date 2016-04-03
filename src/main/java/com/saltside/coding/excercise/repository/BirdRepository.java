package com.saltside.coding.excercise.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saltside.coding.excercise.db.Bird;

/**
 * Selectively expose CRUD methods by simply declaring methods of the
 * same signature as those declared in {@link org.springframework.data.repository.CrudRepository}.
 * 
 * @author amarnath
 */

public interface BirdRepository extends MongoRepository<Bird, String> {

}
