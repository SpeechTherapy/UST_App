package com.ust.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="patients_progess_word")
public class PatientsProgressWord
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Patients_progess_id",nullable = false)
	private int patientsprogressId;
	
	@Column(name="patients_progess",nullable = false)
	private String patientsprogress;

	@JsonIgnore
	@ManyToOne(targetEntity = AssignedChapterTherapist.class,fetch = FetchType.LAZY)
	@JoinColumn(name="Assigned_Chapter_therapist",nullable = false) 
	private AssignedChapterTherapist assignedChapterTherapist;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Word_id",nullable = false)
	private Words words;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Recorded_id",nullable = false)
	private Records records;
	

	public int getPatientsprogressId() {
		return patientsprogressId;
	}

	

	public void setPatientsprogressId(int patientsprogressId) {
		this.patientsprogressId = patientsprogressId;
	}

	public String getPatientsprogress() {
		return patientsprogress;
	}

	public void setPatientsprogress(String patientsprogress) {
		this.patientsprogress = patientsprogress;
	}

	public Words getWords() {
		return words;
	}

	public void setWords(Words words) {
		this.words = words;
	}

	public Records getRecords() {
		return records;
	}

	public void setRecords(Records records) {
		this.records = records;
	}

	public AssignedChapterTherapist getAssignedChapterTherapist() {
		return assignedChapterTherapist;
	}

	public void setAssignedChapterTherapist(AssignedChapterTherapist assignedChapterTherapist) {
		this.assignedChapterTherapist = assignedChapterTherapist;
	}
	
	
	

	
}