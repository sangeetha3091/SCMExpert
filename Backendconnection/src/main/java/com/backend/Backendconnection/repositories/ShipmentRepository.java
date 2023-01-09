package com.backend.Backendconnection.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.backend.Backendconnection.models.Shipment;

@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String> {

	Shipment findByShipmentNo(String shipment_no, String container_no);
}
 