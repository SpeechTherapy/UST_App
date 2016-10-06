package com.ust.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;//persistence is used for transaction

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User 
{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_id",nullable = false)
	private int userId;
	
	@Column(name="Email",nullable = false)
	private String email;
	
	@Column(name="Username",nullable = false)
	private String userName;
	
	@Column(name="User_Password",nullable = false)
	private String userPassword;
	
	@Column(name="User_pic",nullable=true)
	private String userPic;
	
	@Column(name="Reset_Password", nullable=true)
	private int resetPassword;
	
	@Column(name="User_Status" , nullable=false)
	private int userStatus;
	
	@Column(name="User_isActive" , nullable=false)
	private int userIsActive;
	
	@JsonIgnore
	 @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	 Set<Therapist>therapist= new HashSet<Therapist>();
	 
	 @JsonIgnore
	 @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	 Set<Patient> patient= new HashSet<Patient>();
	 
	 @JsonIgnore
	 @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	 Set<Admin> admin= new HashSet<Admin>();
	 
	 
	 public Set<Admin> getAdmin() {
		return admin;
	}
	public void setAdmin(Set<Admin> admin) {
		this.admin = admin;
	}
	public Set<Patient> getPatient() {
	  return patient;
	 }
	 public void setPatient(Set<Patient> patient) {
	  this.patient = patient;
	 }
	 public Set<Therapist> getTherapist() {
	  return therapist;
	 }
	 public void setTherapist(Set<Therapist> therapist) {
	  this.therapist = therapist;
	 }
	
	public int getResetPassword() 
	{
		return resetPassword;
	}
	public void setResetPassword(int resetPassword) 
	{
		this.resetPassword = resetPassword;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
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
	
}
