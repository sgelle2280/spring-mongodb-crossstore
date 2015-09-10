package com.hcc.riab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcc.riab.model.Users;
import com.hcc.riab.service.UserService;

@Controller
@RequestMapping("/rest/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @return list of records
	 */
	@RequestMapping(value="/records" , method=RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody List<Users> getUsers() {		
		return userService.readAll();
	}
	
	/**
	 * 
	 * @param user
	 * @return User information
	 */
	@RequestMapping(value="/get", method=RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Users get(@RequestBody Users user) {
		return userService.read(user);
	}

	/**
	 * This methos is used to create a new user
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param role
	 * @return nothing
	 */
	@RequestMapping(value="/create", method=RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Users create(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam Integer role) {		
		
		Users newUser = new Users();
		newUser.setUserName(username);
		newUser.setPassword(password);
		newUser.setFirstname(firstName);
		newUser.setLastname(lastName);
		
		return userService.create(newUser);
	}
	
	/**
	 * This method is used to update existing user
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param role
	 * @return nothing
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Users update(
			@RequestParam String username,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam Integer role) {
		
		Users existingUser = new Users();
		existingUser.setUserName(username);
		existingUser.setFirstname(firstName);
		existingUser.setLastname(lastName);

		
		return userService.update(existingUser);
	}
	
	/**
	 * This method is used to delete a user
	 * @param username
	 * @return nothing
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Boolean delete(
			@RequestParam String username) {

		Users existingUser = new Users();
		existingUser.setUserName(username);
		
		return userService.delete(existingUser);
	}
}