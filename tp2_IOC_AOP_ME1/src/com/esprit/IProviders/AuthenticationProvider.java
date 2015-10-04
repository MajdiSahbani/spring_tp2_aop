package com.esprit.IProviders;

import java.util.List;

import com.esprit.entities.User;

public interface AuthenticationProvider {
	
	public void addUser(User user);
	public void setUsers(List<User> users);
	public List<User> getUsers();

}
