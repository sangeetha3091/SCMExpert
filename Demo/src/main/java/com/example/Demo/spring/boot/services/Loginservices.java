package com.example.Demo.spring.boot.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.Demo.spring.boot.entities.Login;

@Service
public class Loginservices {

	private RestTemplate restTemplate;
	

	@Value("${spring.localurl}")
	private String localurl;

	@Autowired
	public Loginservices(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	public ResponseEntity<String> getUsers(String email, String password) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		HttpEntity<Login> entity = new HttpEntity<Login>(login);
		System.out.print(entity);
		
		//for local demo uncomment these lines
		return restTemplate.exchange("http://"+localurl+":8010/login", HttpMethod.POST, entity, String.class);
		 
		// return restTemplate.exchange("http://"+ localdockerurl +":8010/login", HttpMethod.POST, entity, String.class);

		//for cloud deploy make these lines up and create docker image
	   //return restTemplate.exchange("http://"+ cloudurl +":8010/login", HttpMethod.POST, entity, String.class);
	}
}