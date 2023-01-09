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

import com.example.Demo.spring.boot.entities.Login;
import com.example.Demo.spring.boot.services.Loginservices;

@Controller
public class LoginController {

	@Autowired
	private Loginservices service;

	ResponseEntity<String> users;

	public LoginController(Loginservices service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private ModelAndView getSignup(ModelAndView model) {
		model.addObject("user", new Login());
		model.setViewName("Login");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String Employee(@ModelAttribute("user") @Valid Login user, BindingResult result) {
		

		users = service.getUsers(user.getEmail(), user.getPassword());
	

		if (users.getHeaders().get("Custom-Header").toString().equals("[failure]")) {
			ObjectError error1 = new ObjectError("globalError", "Invalid Username or Password");
			result.addError(error1);
			return "Login";
		} else {
			return "Dashboard";
		}
		

	}

}
