package com.example.Demo.spring.boot.validation;

import java.util.regex.Pattern;

import javax.validation.Valid;

import com.example.Demo.spring.boot.entities.Register;

public class RegisterValidation {

	public static String validation1(@Valid Register user) {

		String message = "";

		String password = user.getPassword();
		String cpassword = user.getCpassword();
		Pattern specialCharPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Pattern UpperCasePattern = Pattern.compile("[A-Z ]");
		Pattern lowerCasePattern = Pattern.compile("[a-z ]");
		Pattern digitCasePattern = Pattern.compile("[0-9 ]");

		String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-.]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{3}$";

		if (user.getUserName().length() == 0) {
			message = "Name should not be null ";
		} else if (user.getUserName().length() < 6) {
			message = "Name should between 6-15 characters ";
		} else if (user.getUserName().length() > 15) {
			message = "Name should not exists 15 characters ";
		}

		else if (password.length() < 8) {
			message = "Password should between 8-15 Characters ";
		} else if (!specialCharPattern.matcher(password).find()) {
			message = "Password should contain atleast 1 Special Character ";
		} else if (!UpperCasePattern.matcher(password).find()) {
			message = "Password should contain atleast 1 Upper Character ";
		} else if (!lowerCasePattern.matcher(password).find()) {
			message = "Password should contain 1 lowercase character ";
		} else if (!digitCasePattern.matcher(password).find()) {
			message = "Password should contain atleast 1 number ";
		} else if (password.length() > 15) {
			message = "Password limit exists";
		} else if (cpassword.length() > 15) {
			message = "Confirm password limit exists";
		} else if (!password.equals(cpassword)) {
			message = "Password and confirm password is not matches";
		} else if (user.getEmail().isBlank()) {
			message = "Email should not empty";
		} else if (!user.getEmail().matches(emailPattern)) {
			message = "Invalid Email";
		}

		return message;

	}

}
