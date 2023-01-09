package com.backend.Backendconnection.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.Backendconnection.models.DeviceData;


@Repository
public interface DeviceDataRepository extends MongoRepository<DeviceData, String> {

	 
}