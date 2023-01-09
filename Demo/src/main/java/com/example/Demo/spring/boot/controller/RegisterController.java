package com.example.Demo.spring.boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Demo.spring.boot.entities.Register;
import com.example.Demo.spring.boot.services.Registerservices;
import com.example.Demo.spring.boot.validation.PasswordEncryption;
import com.example.Demo.spring.boot.validation.RegisterValidation;

@Controller
public class RegisterController {

	@Autowired
	private Registerservices service;

	public static ResponseEntity<String> RegisterData;

	public RegisterController(Registerservices service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	private ModelAndView getSignup(ModelAndView model) {

		model.addObject("user", new Register());

		model.setViewName("register");
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postUsers(@ModelAttribute("user") @Valid Register user, BindingResult result,RedirectAttributes redirAttrs) {

		  
		   ResponseEntity<String> map= service.getUsers();
		 
		   System.out.print(map.getBody().formatted("userName"));
	
		if (user.getUserName().equals(map.getBody())) {
			
			ObjectError error = new ObjectError("globalError", "Username is already taken!");
			result.addError(error);
		} else {
			
		}

		String err = RegisterValidation.validation1(user);
		if (!err.isEmpty()) {
			ObjectError error1 = new ObjectError("globalError", err);
			result.addError(error1);
		}
		if (result.hasErrors()) {
			return "register";
		}
		PasswordEncryption.encryption(user);
		
		service.saveUsers(user);
		return "redirect:/register?success";

	}
}


