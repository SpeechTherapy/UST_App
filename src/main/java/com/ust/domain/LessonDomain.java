package com.ust.domain;

public class LessonDomain {
	private int lessonId;	
	private String lesson;
	private String videoReference;
	private int assignedChapterTherapist;
	private int status;
	private String lessonPic;
	
	
	

	
	public String getLessonPic() {
		return lessonPic;
	}
	public void setLessonPic(String lessonPic) {
		this.lessonPic = lessonPic;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAssignedChapterTherapist() {
		return assignedChapterTherapist;
	}
	public void setAssignedChapterTherapist(int assignedChapterTherapist) {
		this.assignedChapterTherapist = assignedChapterTherapist;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	public String getVideoReference() {
		return videoReference;
	}
	public void setVideoReference(String videoReference) {
		this.videoReference = videoReference;
	}

}
