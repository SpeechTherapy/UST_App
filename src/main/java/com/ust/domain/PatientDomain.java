package com.ust.domain;

import java.sql.Date;


public class PatientDomain {
	
	private int patientId;
	private int therapistId;
	private int userId;
	private String guradianName;
	private Date patientDob;
	private Date createdOn; 
	private String userName;
	private String userPassword;
	private String email;
	private String patientName;
	private String patientGender;
	private String patientAge;
	private String contactNum;
	private String languageSpoken;
	private String allergies;
	private String Pic;
	private String patientUsername;
	
	
	
	
	
	
	
	public String getPatientUsername() {
		return patientUsername;
	}
	public void setPatientUsername(String patientUsername) {
		this.patientUsername = patientUsername;
	}
	public String getPic() {
		return Pic;
	}
	public void setPic(String Pic) {
		this.Pic = Pic;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getLanguageSpoken() {
		return languageSpoken;
	}
	public void setLanguageSpoken(String languageSpoken) {
		this.languageSpoken = languageSpoken;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
	public String getGuradianName() {
		return guradianName;
	}
	public void setGuradianName(String guradianName) {
		this.guradianName = guradianName;
	}

	public Date getPatientDob() {
		return patientDob;
	}
	public void setPatientDob(Date patientDob) {
		this.patientDob = patientDob;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	
}
