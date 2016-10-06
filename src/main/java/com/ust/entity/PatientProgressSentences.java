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
@Table(name = "patient_progress_sentences")
public class PatientProgressSentences {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Patient_progress_sentences_id",nullable = false)
	private int patientProgressSentencesId;
	
	@Column(name="Patient_progress_sentences",nullable = false)
	private String patientProgressSentences;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Assigned_chapter_therapist",nullable = false)
	private AssignedChapterTherapist assignedChapterTherapist;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Sentences_id",nullable = false)
	private Sentences sentencesId;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="recorded_id", nullable=false)
	private Records recordedId;
	

	
	
	
	public int getPatientProgressSentencesId() {
		return patientProgressSentencesId;
	}

	public void setPatientProgressSentencesId(int patientProgressSentencesId) {
		this.patientProgressSentencesId = patientProgressSentencesId;
	}

	public String getPatientProgressSentences() {
		return patientProgressSentences;
	}

	public void setPatientProgressSentences(String patientProgressSentences) {
		this.patientProgressSentences = patientProgressSentences;
	}

	public AssignedChapterTherapist getAssignedChapterTherapist() {
		return assignedChapterTherapist;
	}

	public void setAssignedChapterTherapist(AssignedChapterTherapist assignedChapterTherapist) {
		this.assignedChapterTherapist = assignedChapterTherapist;
	}

	public Sentences getSentencesId() {
		return sentencesId;
	}

	public void setSentencesId(Sentences sentencesId) {
		this.sentencesId = sentencesId;
	}

	public Records getRecordedId() {
		return recordedId;
	}

	public void setRecordedId(Records recordedId) {
		this.recordedId = recordedId;
	}

	
	

}
