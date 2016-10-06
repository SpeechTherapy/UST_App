package com.ust.domain;

public class UserDomain {
	
	private int userId;
	
	private String userName;
	
	private String email;
	
	private String userPassword;
	
	private String name;
	
	private String userPic;
	
	private int userStatus;
	
	private int userIsActive;
	
	

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public int getUserIsActive() {
		return userIsActive;
	}

	public void setUserIsActive(int userIsActive) {
		this.userIsActive = userIsActive;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
