package com.sametakgul.mongodb_demo.repository;

import com.sametakgul.mongodb_demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
