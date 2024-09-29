package com.niladri.Journalapp.repository;

import com.niladri.Journalapp.model.JournalModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalModel, ObjectId> {
}
