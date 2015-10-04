package com.esprit.Providers;

import java.util.List;

import com.esprit.entities.User;

public class SpringAuthenticationProvider extends GenericAuthenticationProvider 
{
	
	public  SpringAuthenticationProvider(List<User> users) {
		super.users = users;
	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUsers(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return super.users;
	}

}
