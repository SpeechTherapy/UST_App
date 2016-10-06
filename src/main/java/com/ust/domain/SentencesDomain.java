package com.ust.domain;


public class SentencesDomain {
	private int sentencesId;
	private String sentencesName;
	private int mediaId;
	private int lessonId;
	private int sentenceIsActive;
	private String picture;
	private String audiofile;
	public int getSentencesId() {
		return sentencesId;
	}
	public void setSentencesId(int sentencesId) {
		this.sentencesId = sentencesId;
	}
	public String getSentencesName() {
		return sentencesName;
	}
	public void setSentencesName(String sentencesName) {
		this.sentencesName = sentencesName;
	}
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public int getSentenceIsActive() {
		return sentenceIsActive;
	}
	public void setSentenceIsActive(int sentenceIsActive) {
		this.sentenceIsActive = sentenceIsActive;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAudiofile() {
		return audiofile;
	}
	public void setAudiofile(String audiofile) {
		this.audiofile = audiofile;
	}
		
	
	
	
}
