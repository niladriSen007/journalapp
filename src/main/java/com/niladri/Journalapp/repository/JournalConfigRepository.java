package com.niladri.Journalapp.repository;

import com.niladri.Journalapp.model.JournalConfigModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalConfigRepository extends MongoRepository<JournalConfigModel, ObjectId> {

}
