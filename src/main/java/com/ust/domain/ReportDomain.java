package com.ust.domain;

import java.util.Date;

public class ReportDomain {
	
	private String patientName;
	private String guardianName;
	private Date dOB;
	private String gender;
	private String age;
	private Date date;
	private String contactNum;
	private String language;
	private String Allergies;
	private String therapistName;
	private String assignedChapter;
	private String lesson;
	private String patientProgressSound;
	private String patientProgressSound_RecordedAudio;
	private String patientProgressWord;
	private String  patientProgressWord_RecordedAudio;
	private String patientProgressSentences;
	private String patientProgressSentences_RecordedAudio;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAllergies() {
		return Allergies;
	}
	public void setAllergies(String allergies) {
		Allergies = allergies;
	}
	public String getTherapistName() {
		return therapistName;
	}
	public void setTherapistName(String therapistName) {
		this.therapistName = therapistName;
	}
	public String getAssignedChapter() {
		return assignedChapter;
	}
	public void setAssignedChapter(String assignedChapter) {
		this.assignedChapter = assignedChapter;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	public String getPatientProgressSound() {
		return patientProgressSound;
	}
	public void setPatientProgressSound(String patientProgressSound) {
		this.patientProgressSound = patientProgressSound;
	}
	public String getPatientProgressSound_RecordedAudio() {
		return patientProgressSound_RecordedAudio;
	}
	public void setPatientProgressSound_RecordedAudio(String patientProgressSound_RecordedAudio) {
		this.patientProgressSound_RecordedAudio = patientProgressSound_RecordedAudio;
	}
	public String getPatientProgressWord() {
		return patientProgressWord;
	}
	public void setPatientProgressWord(String patientProgressWord) {
		this.patientProgressWord = patientProgressWord;
	}
	public String getPatientProgressWord_RecordedAudio() {
		return patientProgressWord_RecordedAudio;
	}
	public void setPatientProgressWord_RecordedAudio(String patientProgressWord_RecordedAudio) {
		this.patientProgressWord_RecordedAudio = patientProgressWord_RecordedAudio;
	}
	public String getPatientProgressSentences() {
		return patientProgressSentences;
	}
	public void setPatientProgressSentences(String patientProgressSentences) {
		this.patientProgressSentences = patientProgressSentences;
	}
	public String getPatientProgressSentences_RecordedAudio() {
		return patientProgressSentences_RecordedAudio;
	}
	public void setPatientProgressSentences_RecordedAudio(String patientProgressSentences_RecordedAudio) {
		this.patientProgressSentences_RecordedAudio = patientProgressSentences_RecordedAudio;
	}

}
