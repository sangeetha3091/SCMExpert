package com.backend.Backendconnection.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import static com.backend.Backendconnection.constants.ValueConstants.users_collection;
@Document(users_collection)
public class RegisterUsers {

	@Id
	private String id;
	private String userName;
	private String password;
	private String email;

	public RegisterUsers() {

		// TODO Auto-generated constructor stub
	}

	public RegisterUsers(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}