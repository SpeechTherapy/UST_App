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
@Table(name = "patient_progress_sounds")
public class PatientProgressSound {
	
	public Set<Records> getRecordedAudio() {
		return recordedAudio;
	}
	public void setRecordedAudio(Set<Records> recordedAudio) {
		this.recordedAudio = recordedAudio;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Patient_progress_sounds_id",nullable = false)
	private int patientProgressSoundId;
	
	@Column(name="Patient_progress_sounds",nullable = false)
	private String patientProgressSound;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Assigned_chapter_therapist",nullable = false)
	private AssignedChapterTherapist assignedChapterTherapist;
	
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Sounds_id",nullable = false)
	private Sounds sounds;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Recorded_id",nullable = false)
	private Records records;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="recordedAudio")
	Set<Records> recordedAudio= new HashSet<Records>();
	
	
	
	
	
	public int getPatientProgressSoundId() {
		return patientProgressSoundId;
	}
	public void setPatientProgressSoundId(int patientProgressSoundId) {
		this.patientProgressSoundId = patientProgressSoundId;
	}
	public String getPatientProgressSound() {
		return patientProgressSound;
	}
	public void setPatientProgressSound(String patientProgressSound) {
		this.patientProgressSound = patientProgressSound;
	}
	public AssignedChapterTherapist getAssignedChapterTherapist() {
		return assignedChapterTherapist;
	}
	public void setAssignedChapterTherapist(AssignedChapterTherapist assignedChapterTherapist) {
		this.assignedChapterTherapist = assignedChapterTherapist;
	}
	public Sounds getSounds() {
		return sounds;
	}
	public void setSounds(Sounds sounds) {
		this.sounds = sounds;
	}
	public Records getRecords() {
		return records;
	}
	public void setRecords(Records records) {
		this.records = records;
	}
	
	
	

}
