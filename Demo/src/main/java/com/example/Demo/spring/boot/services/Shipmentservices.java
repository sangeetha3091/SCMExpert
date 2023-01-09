package com.example.Demo.spring.boot.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Demo.spring.boot.entities.DeviceData;
import com.example.Demo.spring.boot.entities.Shipment;

@Service
public class Shipmentservices {

	private RestTemplate restTemplate;
	

	
	@Value("${spring.localurl}")
	private String localurl;

	@Autowired
	public Shipmentservices(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	public ResponseEntity<String> saveUsers(Shipment user) {
		HttpEntity<Shipment> entity = new HttpEntity<>(user);
		
		 return restTemplate.exchange("http://"+localurl+":8010/shipment", HttpMethod.POST, entity, String.class);
		
		
		 //return restTemplate.exchange("http://"+cloudurl+":8010/shipment", HttpMethod.POST, entity, String.class);
	}

	public ResponseEntity<String> getUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

		 return restTemplate.exchange("http://"+localurl+":8010/getShipment", HttpMethod.GET, entity, String.class);
		 
		
		
		// return restTemplate.exchange("http://"+cloudurl+":8010/getShipment", HttpMethod.GET, entity, String.class);
	}

	public ResponseEntity<List<DeviceData>> getData() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);
		// ResponseEntity<String>
		// result=restTemplate.exchange("http://"+localurl+":8080/getData", HttpMethod.GET,
		// entity, String.class);
		
		return restTemplate.exchange("http://"+localurl+":8010/getData", HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<DeviceData>>() {
				});
		
		
//		
//	return restTemplate.exchange("http://"+cloudurl+":8010/getData", HttpMethod.GET, entity,
//				new ParameterizedTypeReference<List<DeviceData>>() {
//			});

	}
}
