package com.social.imageApp.account.model;

public class UserRegRequestDTO {

	private String userName;
	private String password;
	private String email;
	private boolean isAdmin;

	public UserRegRequestDTO() {
	}

	public UserRegRequestDTO(String userName, String password, String email, boolean isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
