package com.ust.domain;

import java.sql.Date;

import javax.mail.Multipart;


public class TherapistDomain {
	
	private int therapistId;
	private int userId;
	private String hospitalName;
	private String contactNumber;
	private Date createdOn;
	private String therapistGender;
	private String hospAddress;
	private int cityId;
	private String Picture;
	private String email;
	private String password;
	private String Name;
	private String Username;
	
	
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getTherapistGender() {
		return therapistGender;
	}
	public void setTherapistGender(String therapistGender) {
		this.therapistGender = therapistGender;
	}
	public String getHospAddress() {
		return hospAddress;
	}
	public void setHospAddress(String hospAddress) {
		this.hospAddress = hospAddress;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
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
	
	
	public int getTherapistId() {
		return therapistId;
	}
	public void setTherapistId(int therapistId) {
		this.therapistId = therapistId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
	

}
