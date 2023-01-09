package com.backend.Backendconnection.services;

import java.util.List;

import com.backend.Backendconnection.models.Shipment;

public interface ShipmentServices {

	public void ShipmentData(com.backend.Backendconnection.models.Shipment users);

	public boolean Authenticate(String shipment_no, String container_no);

	public List<Shipment> getshipmentdata();

}
