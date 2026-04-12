package com.joaogabriel.mongoproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaogabriel.mongoproject.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
