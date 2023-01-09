package com.backend.Backendconnection.services;

import java.util.List;

public interface RegisterServices {
	public void RegisterUsers(com.backend.Backendconnection.models.RegisterUsers users);

	public boolean Authenticate(String email, String password);

	public Object getUser(String email, String password) throws Exception;

	public List<com.backend.Backendconnection.models.RegisterUsers> getallUsers();

}
