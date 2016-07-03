package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByLastName(@Param("name") String name);
}
