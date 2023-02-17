package com.tns.placment_management_system.model;

public class Login {
	private String username;
	private String password;
	public Login() {	
	}
	
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
}
