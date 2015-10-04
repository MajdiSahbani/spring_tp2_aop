package com.esprit.entities;

import java.util.List;

public class User {

	private String password;
	private String username;
	private List<Role> roles;
	
	
	public User(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [password=" + password + ", username=" + username + ", roles=" + roles + "]";
	}
	
	
}
