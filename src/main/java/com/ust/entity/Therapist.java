package com.ust.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "therapist")
public class Therapist {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Therapist_id",nullable = false)
	private int therapistId;
	
	@Column(name="Created_on",nullable=false)
	private Date createdDate;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hospital_id",nullable = true)
	private Hospital hospital;

	
	@Column(name="Therapist_contactno")
	private String therapistContact;
	
	@Column(name="Therapist_Name", nullable = false)
	private String therapistName;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id",nullable = false)
	private User user;
	
	
	@Column(name="Therapist_gender")
	private String therapistGender;
	
	
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="therapist")
	Set<Patient> patient= new HashSet<Patient>();

	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="therapist")
	Set<Post> post= new HashSet<Post>();
	
	
	

	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}

	public String getTherapistName() {
		return therapistName;
	}

	public void setTherapistName(String therapistName) {
		this.therapistName = therapistName;
	}

	public String getTherapistGender() {
		return therapistGender;
	}

	public void setTherapistGender(String therapistGender) {
		this.therapistGender = therapistGender;
	}

	public int getTherapistId() {
		return therapistId;
	}

	public void setTherapistId(int therapistId) {
		this.therapistId = therapistId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getTherapistContact() {
		return therapistContact;
	}

	public void setTherapistContact(String therapistContact) {
		this.therapistContact = therapistContact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
