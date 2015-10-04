package com.esprit.Providers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.IProviders.AuthenticationProvider;
import com.esprit.entities.User;

public abstract class GenericAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	List<User> users;

	
	
}
