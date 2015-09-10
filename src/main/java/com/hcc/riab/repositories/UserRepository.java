package com.hcc.riab.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hcc.riab.model.Users;

/**
 * Specifies methods used to obtain and modify users related information
 * which is stored in the mongo database.
 * 
 * @author sgelle
 *
 */

public interface UserRepository extends MongoRepository<Users, String> {
	
	/**
	 * Finds users by using the user name as a search criteria.
	 * @param userName
	 * @return A list of users which user name is an exact match with the given userName.
     *          If no records is found, this method returns an empty list.
	 */
	Users findByUserName(String userName);
}