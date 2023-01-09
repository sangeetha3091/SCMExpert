package com.backend.Backendconnection.validation;

import java.util.regex.Pattern;
import static com.backend.Backendconnection.constants.ValueConstants.EMAIL_PATTERN;
import static com.backend.Backendconnection.constants.ValueConstants.not_empty;
import static com.backend.Backendconnection.constants.ValueConstants.special_case_error;
import static com.backend.Backendconnection.constants.ValueConstants.lower_case_error;
import static com.backend.Backendconnection.constants.ValueConstants.upper_case_error;
import static com.backend.Backendconnection.constants.ValueConstants.email_valid;
import static com.backend.Backendconnection.constants.ValueConstants.number_error;
import static com.backend.Backendconnection.constants.ValueConstants.password_length_error;
import static com.backend.Backendconnection.constants.ValueConstants.special_char;

 
public class RegisterValidation {
	
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public static boolean username(String username) throws Exception {
		if (username.length()==0) {
			throw new Exception(not_empty);
		}
		return true;

	}

	public static boolean password(String password) throws Exception {
		boolean valid = true;
		if (password.length() < 8) {
			throw new Exception(password_length_error);
			
		 }

		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			throw new Exception(upper_case_error);
			 
		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			throw new Exception(lower_case_error);
			
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			throw new Exception(number_error);
			
		}
		 
		if (!password.matches(special_char)) {
			throw new Exception(special_case_error);
			
		}
		
		return valid;

	}

	public static boolean email(String email) throws Exception {
		java.util.regex.Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {

		} else {
			throw new Exception(email_valid);
		}
		return true;

	}

}
