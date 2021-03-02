package com;

import java.sql.Timestamp;

public class Signup {		//creating fields for form
	private int pid;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String gender;
	Timestamp doe;
	public Signup() {		//default constructor
		
	}
	
	//parameterized constructor
	public Signup(String username, String password, String name, String email, String phone, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}

	// setters
	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}
	
	

	@Override
	public String toString() {
		return "form [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", gender=" + gender + "]";
	}

	
}
