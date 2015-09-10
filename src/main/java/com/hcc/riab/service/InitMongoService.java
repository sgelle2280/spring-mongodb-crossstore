package com.hcc.riab.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hcc.riab.model.Users;

/**
 * Service for initializing MongoDB with sample data using {@link MongoTemplate}
 */
public class InitMongoService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public void init() {
		// Drop existing collections
		mongoTemplate.dropCollection("role");
		mongoTemplate.dropCollection("user");

		// Create new records
	
		
		Users john = new Users();
		john.setId(UUID.randomUUID().toString());
		john.setFirstname("John");
		john.setLastname("Smith");
		john.setPassword("21232f297a57a5a743894a0e4a801fc3");

		john.setUserName("john");
		
		Users jane = new Users();
		jane.setId(UUID.randomUUID().toString());
		jane.setFirstname("Jane");
		jane.setLastname("Adams");
		jane.setPassword("ee11cbb19052e40b07aac0ca060c23ee");

		jane.setUserName("jane");
		
		// Insert to db
		mongoTemplate.insert(john, "user");
		mongoTemplate.insert(jane, "user");

	}
}