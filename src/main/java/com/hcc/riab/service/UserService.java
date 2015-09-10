package com.hcc.riab.service;
import java.util.List;
import java.util.UUID;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcc.riab.model.Users;
import com.hcc.riab.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	/**
	 * 
	 * @param user
	 * @return user information.
	 */
	public Users create(Users user) {
		user.setId(UUID.randomUUID().toString());
		
		return userRepository.save(user);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Users read(Users user) {
		return user;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Users> readAll() {
		return userRepository.findAll();
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Users update(Users user) {
		Users existingUser = userRepository.findByUserName(user.getUserName());
		
		if (existingUser == null) {
			return null;
		}
		
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());		
		
		return userRepository.save(existingUser);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Boolean delete(Users user) {
		Users existingUser = userRepository.findByUserName(user.getUserName());
		
		if (existingUser == null) {
			return false;
		}
		
		// We must delete both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		
		userRepository.delete(existingUser);
		return true;
	}
}