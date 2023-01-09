package com.backend.Backendconnection.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.backend.Backendconnection.models.RegisterUsers;

@Repository
public interface RegisterRepository extends MongoRepository<RegisterUsers, String> {

	RegisterUsers findByemail(String email);

	boolean existsByEmail(String string);

}
