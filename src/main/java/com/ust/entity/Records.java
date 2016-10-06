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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recorded_audio")
public class Records {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Recorded_Audio_id",nullable = false)
	private int recordedAudioId;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient_id",nullable = false)
	private Patient patient;
	
	@JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lesson_id",nullable = false)
	private Lesson lesson;
	
	@Column(name="Recorded_Audios")
	private String recordedAudio;
	
	/*	
 * @JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="recordedAudio")
	Set<PatientProgressSentences> patientRecordProgressSentences= new HashSet<PatientProgressSentences>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="recordedAudio")
	Set<PatientProgressSound> patientRecordProgressSound= new HashSet<PatientProgressSound>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="recordedAudio")
	Set<PatientsProgressWord> patientsRecordProgressWord= new HashSet<PatientsProgressWord>();
	
	 public Set<PatientProgressSentences> getPatientRecordProgressSentences() {
		return patientRecordProgressSentences;
	}
	public void setPatientRecordProgressSentences(Set<PatientProgressSentences> patientRecordProgressSentences) {
		this.patientRecordProgressSentences = patientRecordProgressSentences;
	}
	public Set<PatientProgressSound> getPatientRecordProgressSound() {
		return patientRecordProgressSound;
	}
	public void setPatientRecordProgressSound(Set<PatientProgressSound> patientRecordProgressSound) {
		this.patientRecordProgressSound = patientRecordProgressSound;
	}
	public Set<PatientsProgressWord> getPatientsRecordProgressWord() {
		return patientsRecordProgressWord;
	}
	public void setPatientsRecordProgressWord(Set<PatientsProgressWord> patientsRecordProgressWord) {
		this.patientsRecordProgressWord = patientsRecordProgressWord;
	} */
	public int getRecordedAudioId() {
		return recordedAudioId;
	}
	public void setRecordedAudioId(int recordedAudioId) {
		this.recordedAudioId = recordedAudioId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public String getRecordedAudio() {
		return recordedAudio;
	}
	public void setRecordedAudio(String recordedAudio) {
		this.recordedAudio = recordedAudio;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	
	
	
	

}
