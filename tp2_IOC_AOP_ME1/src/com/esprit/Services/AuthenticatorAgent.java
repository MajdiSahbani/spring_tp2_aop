package com.esprit.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.esprit.IProviders.AuthenticationProvider;
import com.esprit.IServices.Authenticator;
import com.esprit.entities.User;

@Component("AuthenticatorAgent")
public class AuthenticatorAgent implements Authenticator 
{
	@Autowired
	@Qualifier("mock")
	private AuthenticationProvider iprovider;
	
	
	
	
	

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		/*
		if((username.equals("admin") && password.equals("adminpassword")) || (username.equals("user") && password.equals("userpassword")))
		{
			return true;
		}
		*/
		for(int i = 0; i < 100000; i++)
		{
			;
		}
		for(User u : iprovider.getUsers())
		{
			if(u.getPassword().equals(password) && u.getUsername().equals(username))
			{
				return true;
			}
		}
		return false;
	}

	public AuthenticationProvider getIprovider() {
		return iprovider;
	}

	public void setIprovider(AuthenticationProvider iprovider) {
		this.iprovider = iprovider;
	}
	
	

}
