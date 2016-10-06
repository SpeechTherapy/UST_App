package com.ust.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Patient_id",nullable = false)
	private int patientId;
	
	@Column(name="Patient_guardian_name",nullable = true)
	private String patientGuardianName;
	
	@Column(name="Patient_dob",nullable = true)
	private Date patientDob;
	
	@Column(name="patient_createdon",nullable = false)
	private Date createdDate;
	
	@Column(name="Gender",nullable = true)
	private String patientGender;
	
	@Column(name="Patient_Name", nullable= true)
	private String patientName;
	
	@Column(name="Age",nullable = true)
	private String patientAge;
	
	@Column(name="Contact_no",nullable= true)
	private String contactNum;
	
	@Column(name="Allergies", nullable= true)
	private String allergies;
	
	@Column(name="Language_Spoken", nullable= true)
	private String languageSpoken;
	
	

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Therapist_id",nullable = false)
	private Therapist therapist;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id",nullable = false)
	private User user;
	
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="patient")
	Set<AssignedChapterTherapist> assignedchapterTherapist= new HashSet<AssignedChapterTherapist>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="patient")
	Set<Records> recordedAudio = new HashSet<Records>();
	
	


	public Set<Records> getRecordedAudio() {
		return recordedAudio;
	}

	public void setRecordedAudio(Set<Records> recordedAudio) {
		this.recordedAudio = recordedAudio;
	}

	public Set<AssignedChapterTherapist> getAssignedchapterTherapist() {
		return assignedchapterTherapist;
	}

	public void setAssignedchapterTherapist(Set<AssignedChapterTherapist> assignedchapterTherapist) {
		this.assignedchapterTherapist = assignedchapterTherapist;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
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

	public String getPatientGuardianName() {
		return patientGuardianName;
	}

	public void setPatientGuardianName(String patientGuardianName) {
		this.patientGuardianName = patientGuardianName;
	}

	public Date getPatientDob() {
		return patientDob;
	}

	public void setPatientDob(Date patientDob) {
		this.patientDob = patientDob;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Therapist getTherapist() {
		return therapist;
	}

	public void setTherapist(Therapist therapist) {
		this.therapist = therapist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
