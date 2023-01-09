package com.example.Demo.spring.boot.validation;

import org.jasypt.util.text.AES256TextEncryptor;
import com.example.Demo.spring.boot.entities.Register;
import javax.validation.Valid;


public class PasswordEncryption {
	public static String encryption(@Valid Register user) {
		AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
		aesEncryptor.setPassword("mypassword");
		String myEncryptedPassword = aesEncryptor.encrypt(user.getPassword());
		System.out.println(myEncryptedPassword);
		user.setPassword(myEncryptedPassword);
		return myEncryptedPassword;
	}

	

 

}
