package com.ust.domain;

import com.ust.entity.Lesson;
import com.ust.entity.Patient;

public class RecordsDomain {
	private int recordedAudioId;
	private int patientId;
	private int lessonId;
	private String recordedAudio;
	
	public int getRecordedAudioId() {
		return recordedAudioId;
	}
	public void setRecordedAudioId(int recordedAudioId) {
		this.recordedAudioId = recordedAudioId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getRecordedAudio() {
		return recordedAudio;
	}
	public void setRecordedAudio(String recordedAudio) {
		this.recordedAudio = recordedAudio;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	
	

	
}
