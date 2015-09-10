package com.hcc.riab.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="users")
public class Users {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String userName;
    private String password;

    public Users() {}

    public Users(String firstName, String lastName) {
        this.firstname = firstName;
        this.lastname = lastName;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}