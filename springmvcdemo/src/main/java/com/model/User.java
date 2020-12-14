package com.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	private int userId;
	@NotEmpty(message="custom username")
	@Size(min=1,max=10)
	private String userName;
	@NotEmpty(message="custom password")
	@Size(min=1)
	private String password;

	public User() {
		super();
	}

	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
