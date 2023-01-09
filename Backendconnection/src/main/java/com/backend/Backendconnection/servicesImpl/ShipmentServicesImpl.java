package com.backend.Backendconnection.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Backendconnection.models.Shipment;
import com.backend.Backendconnection.repositories.ShipmentRepository;
import com.backend.Backendconnection.services.ShipmentServices;

@Service
public class ShipmentServicesImpl implements ShipmentServices {
	@Autowired
	private ShipmentRepository repo;

	@Override
	public void ShipmentData(com.backend.Backendconnection.models.Shipment users) {
		repo.save(users);
		// TODO Auto-generated method stub

	}

	public ShipmentServicesImpl(ShipmentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public boolean Authenticate(String shipment_no, String container_no) {
		Shipment users = repo.findByShipmentNo(shipment_no, container_no);
		if (users == null
				|| (!users.getShipmentNo().equals(shipment_no) || (!users.getContainerNo().equals(container_no)))) {
			return false;
		}
		return true;
	}

	@Override
	public List<Shipment> getshipmentdata() {
		 
		return repo.findAll();
	}

}
