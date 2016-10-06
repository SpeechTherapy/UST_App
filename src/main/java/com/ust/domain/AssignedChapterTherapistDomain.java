package com.ust.domain;


public class AssignedChapterTherapistDomain {
	private int assignedChapterId;
	private int patientId;
	private int lessonId;
	private int status;
	
	
	
	public int getAssignedChapterId() {
		return assignedChapterId;
	}
	public void setAssignedChapterId(int assignedChapterId) {
		this.assignedChapterId = assignedChapterId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	


}
