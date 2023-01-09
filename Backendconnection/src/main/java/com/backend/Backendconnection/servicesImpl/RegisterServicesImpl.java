package com.backend.Backendconnection.servicesImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.Backendconnection.models.RegisterUsers;
import com.backend.Backendconnection.repositories.RegisterRepository;
import com.backend.Backendconnection.services.RegisterServices;
import com.backend.Backendconnection.validation.PasswordEncryption;
import static com.backend.Backendconnection.constants.ValueConstants.not_found;

@Service
public class RegisterServicesImpl implements RegisterServices {

	@Autowired
	private RegisterRepository repo;

	public RegisterServicesImpl(RegisterRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void RegisterUsers(com.backend.Backendconnection.models.RegisterUsers users) {
		repo.save(users);
		// TODO Auto-generated method stub

	}

	@Override
	public boolean Authenticate(String email, String password) {
		RegisterUsers users = repo.findByemail(email);

		String s = PasswordEncryption.decode(users.getPassword());
		if (users == null || (!s.equals(password))) {
			return false;
		}
		return true;

	}

	@Override
	public com.backend.Backendconnection.models.RegisterUsers getUser(String email, String password) throws Exception {

		RegisterUsers user = repo.findByemail(email);

		if (user.getEmail().equals(email) && (user.getPassword().equals(password))) {
			return user;
		} else {
			throw new Exception(not_found);
		}
	}

	@Override
	public List<com.backend.Backendconnection.models.RegisterUsers> getallUsers() {

		return repo.findAll();
	}

}
