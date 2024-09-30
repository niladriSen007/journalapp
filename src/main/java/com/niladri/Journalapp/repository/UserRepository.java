package com.niladri.Journalapp.repository;

import com.niladri.Journalapp.model.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel, ObjectId> {

    Optional<UserModel> findByUsername(String name);
}
