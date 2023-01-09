package com.example.Demo.spring.boot.entities;

public class Register {
	
	private String userName;
	private String cpassword;
	private String email;
	private String password;
	
	

	public Register() {
		 
		// TODO Auto-generated constructor stub
	}



	public Register(String userName, String cpassword, String email, String password) {
		super();
		this.userName = userName;
		this.cpassword = cpassword;
		this.email = email;
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getCpassword() {
		return cpassword;
	}



	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean confirmPassword() {return this.password.equals(this.cpassword);}
	
}










