package com.niladri.Journalapp.repository;

import com.niladri.Journalapp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<UserModel> getUsersWithSentimentAnalysis() {
		Query query = new Query();
		query.addCriteria(Criteria.where("sentimentAnalysis").is(true)
				.and("email").exists(true)
				.ne(null).ne(""));
		return mongoTemplate.find(query, UserModel.class);
	}
}
