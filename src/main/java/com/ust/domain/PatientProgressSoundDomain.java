package com.ust.domain;

import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Records;
import com.ust.entity.Sentences;
import com.ust.entity.Sounds;

public class PatientProgressSoundDomain {
	private int patientProgressSoundId;
	private String patientProgressSound;
	private int assignedChapterTherapistId;
	private int soundsId;
	private int recordsId;
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
	public int getAssignedChapterTherapistId() {
		return assignedChapterTherapistId;
	}
	public void setAssignedChapterTherapistId(int assignedChapterTherapistId) {
		this.assignedChapterTherapistId = assignedChapterTherapistId;
	}
	public int getSoundsId() {
		return soundsId;
	}
	public void setSoundsId(int soundsId) {
		this.soundsId = soundsId;
	}
	public int getRecordsId() {
		return recordsId;
	}
	public void setRecordsId(int recordsId) {
		this.recordsId = recordsId;
	}
	
	
}
