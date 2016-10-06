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
@Table(name="assigned_chapter_therapist")
public class AssignedChapterTherapist {
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Assigned_Chapter_id",nullable = false)
	private int assignedChapterId;
	
	@Column(name="Status",nullable = false)
	private int status;
	

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient_id",nullable = false)
	private Patient patient;
	

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lesson_id",nullable = false)
	private Lesson lesson;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="assignedChapterTherapist")
	Set<PatientProgressSentences> patientProgressSentences= new HashSet<PatientProgressSentences>();
	
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="assignedChapterTherapist")
	Set<PatientProgressSound> patientProgressSound= new HashSet<PatientProgressSound>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="assignedChapterTherapist")
	Set<PatientsProgressWord> patientsProgressWord= new HashSet<PatientsProgressWord>();
	
	/*@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="assignedChapterTherapist")
	Set<Records> recordedAudio=new HashSet<Records>();*/
	
	
	
	
	
	/* public Set<Records> getRecordedAudio() {
		return recordedAudio;
	}
	public void setRecordedAudio(Set<Records> recordedAudio) {
		this.recordedAudio = recordedAudio;
	} */
	
	public Set<PatientProgressSound> getPatientProgressSound() {
		return patientProgressSound;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setPatientProgressSound(Set<PatientProgressSound> patientProgressSound) {
		this.patientProgressSound = patientProgressSound;
	}
	
	public Set<PatientsProgressWord> getPatientsProgressWord() {
		return patientsProgressWord;
	}
	public void setPatientsProgressWord(Set<PatientsProgressWord> patientsProgressWord) {
		this.patientsProgressWord = patientsProgressWord;
	}
	public Set<PatientProgressSentences> getPatientProgressSentences() {
		return patientProgressSentences;
	}
	public void setPatientProgressSentences(Set<PatientProgressSentences> patientProgressSentences) {
		this.patientProgressSentences = patientProgressSentences;
	}
	
	
	public int getAssignedChapterId() {
		return assignedChapterId;
	}
	public void setAssignedChapterId(int assignedChapterId) {
		this.assignedChapterId = assignedChapterId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

}
