package com.esprit.Providers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.esprit.entities.Role;
import com.esprit.entities.User;

@Component("mock")
public class MockAuthenticationProvider extends GenericAuthenticationProvider {
	
	@PostConstruct
	public void init()
	{
		//List<User> tmpUsers = new ArrayList<User>();
		User akram = new User("akrampassword","akram");
		User nemesis = new User("nemesispassword","nemesis");
		//tmpUsers.add(akram); 
		//tmpUsers.add(nemesis);
		//setUsers(tmpUsers);
		akram.setRoles(new ArrayList<Role>());
		akram.getRoles().add(new Role("view"));
		nemesis.setRoles(new ArrayList<Role>());
		nemesis.getRoles().add(new Role("view"));
		nemesis.getRoles().add(new Role("read"));
		setUsers(new ArrayList<User>());
		addUser(akram);
		addUser(nemesis);
		System.out.println(users.size());
	}
	
	public MockAuthenticationProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(User user) {
		users.add(user);
		
	}

	@Override
	public void setUsers(List<User> users) {
		this.users = users;
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	

}
