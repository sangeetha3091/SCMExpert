package com.backend.Backendconnection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.backend.Backendconnection.models.DeviceData;

import com.backend.Backendconnection.services.DeviceDataServices;

@RestController
public class DeviceDataController {

	@Autowired
	private DeviceDataServices service;

	public DeviceDataController(DeviceDataServices service) {
		super();
		this.service = service;
	}

	public DeviceDataServices getService() {
		return service;
	}

	public void setService(DeviceDataServices service) {
		this.service = service;
	}

	@GetMapping("/getData")
	public List<DeviceData> getAllDeviceData() {

		return service.getdevicedata();

	}

}
