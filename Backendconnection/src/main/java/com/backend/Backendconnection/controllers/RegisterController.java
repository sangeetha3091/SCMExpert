package com.backend.Backendconnection.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.Backendconnection.models.RegisterUsers;
import com.backend.Backendconnection.repositories.RegisterRepository;
import com.backend.Backendconnection.services.RegisterServices;
import com.backend.Backendconnection.servicesImpl.RegisterServicesImpl;

import static com.backend.Backendconnection.validation.RegisterValidation.username;
import static com.backend.Backendconnection.validation.RegisterValidation.email;
import static com.backend.Backendconnection.validation.RegisterValidation.password;

@RestController
public class RegisterController {

	@Autowired
	private RegisterServices service;

	@Autowired
	private RegisterRepository repo;

	public RegisterController(RegisterServicesImpl service) {
		super();
		this.service = service;
	}

	public RegisterServices getService() {
		return service;
	}

	public void setService(RegisterServices service) {
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<Object> saveUsers(@RequestBody RegisterUsers users) throws Exception {
		if (repo.existsByEmail(users.getEmail())) {
			return ResponseEntity.ok().header("Custom-Header", "failure").body("Failure case");

			//return ResponseEntity.badRequest().body(new MessageResponse("Username is ok"));
		}

		username(users.getUserName());
		password(users.getPassword());
		email(users.getEmail());
		service.RegisterUsers(users);
		return ResponseEntity.ok().header("Custom-Header", "success").body("Success case");

	}

	@GetMapping("/getUsers")
	public List<RegisterUsers> getAllEmployees() {
		
		return service.getallUsers();
	}

	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody RegisterUsers users) throws Exception {

		if (!service.Authenticate(users.getEmail(), users.getPassword())) {

			return ResponseEntity.ok().header("Custom-Header", "failure").body("Failure case");

		} else {
			return ResponseEntity.ok().header("Custom-Header", "success").body("Success case");

		}

	}

}
