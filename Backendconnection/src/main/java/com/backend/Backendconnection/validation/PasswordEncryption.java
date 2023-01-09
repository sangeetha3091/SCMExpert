package com.backend.Backendconnection.validation;

import org.jasypt.util.text.AES256TextEncryptor;
import static com.backend.Backendconnection.constants.ValueConstants.passwordencrypt;

public class PasswordEncryption {

	public static String decode(String pswd) {
		AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
		aesEncryptor.setPassword(passwordencrypt);
		String decryptedPassword = aesEncryptor.decrypt(pswd);

		return decryptedPassword;
	}

}
