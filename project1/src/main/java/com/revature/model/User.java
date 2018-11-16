package com.revature.model;

import java.util.List;

public class User {
	
	private int user_id;
	private String username;
	private String password; // this will later be adjusted for security
	private String firstName;
	private String lastName;
	private String email; //I THINK this converts properly?
	private int role_id;
	private UserRole role;
	
	private List<Reimbursement> activeReimbs;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(int user_id, String username, String password, String firstName, String lastName, String email, int role_id,
			UserRole role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role_id = role_id;
		this.role = role;
	}
	
	
	public UserRole getRole() {
		return role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<Reimbursement> getActiveReimbs() {
		return activeReimbs;
	}



	public void setActiveReimbs(List<Reimbursement> activeReimbs) {
		this.activeReimbs = activeReimbs;
	}
	
	
	
	
}
