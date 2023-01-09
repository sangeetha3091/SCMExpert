package com.example.Demo.spring.boot.services;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Demo.spring.boot.entities.Register;

@Service
public class Registerservices {

	private RestTemplate restTemplate;

	


	@Value("${spring.localurl}")
	private String localurl;
	
	@Autowired
	public Registerservices(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	public ResponseEntity<String> saveUsers(Register register) {
		HttpEntity<Register> entity = new HttpEntity<>(register);
		
		 return restTemplate.exchange("http://"+localurl+":8010/register", HttpMethod.POST, entity, String.class);
		
		// return restTemplate.exchange("http://"+cloudurl+":8010/register", HttpMethod.POST, entity, String.class);
	}

	public ResponseEntity<String> getUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

		return restTemplate.exchange("http://"+localurl+":8010/getUsers", HttpMethod.GET, entity, String.class);
	 
		
		// return restTemplate.exchange("http://"+cloudurl+":8010/getUsers", HttpMethod.GET, entity, String.class);
	}

}
