package com.backend.Backendconnection.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Backendconnection.models.DeviceData;

import com.backend.Backendconnection.repositories.DeviceDataRepository;

import com.backend.Backendconnection.services.DeviceDataServices;

@Service
public class DeviceDataServicesImpl implements DeviceDataServices {
	@Autowired
	private DeviceDataRepository repo;

	public DeviceDataServicesImpl(DeviceDataRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<DeviceData> getdevicedata() {

		return repo.findAll();
	}

}
