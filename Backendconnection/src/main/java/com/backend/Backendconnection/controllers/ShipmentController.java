package com.backend.Backendconnection.controllers;

import static com.backend.Backendconnection.validation.ShipmentValidation.validation1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Backendconnection.models.Shipment;
import com.backend.Backendconnection.services.ShipmentServices;

@RestController
public class ShipmentController {

	@Autowired
	private ShipmentServices service;

	public ShipmentController(ShipmentServices service) {
		super();
		this.service = service;
	}

	public ShipmentServices getService() {
		return service;
	}

	public void setService(ShipmentServices service) {
		this.service = service;
	}

	@GetMapping("/getShipment")
	public List<Shipment> getshipmentdata() {

		return service.getshipmentdata();
	}

	@PostMapping("/shipment")
	public ResponseEntity<Object> saveUsers(@RequestBody Shipment users) throws Exception {

		if (!service.Authenticate(users.getShipmentNo(), users.getContainerNo())) {
			validation1(users);
			service.ShipmentData(users);
			return ResponseEntity.ok().header("Custom-Header", "success").body("Success case");

		} else {

			return ResponseEntity.ok().header("Custom-Header", "failure").body("Failure case");

		}

	}

}
