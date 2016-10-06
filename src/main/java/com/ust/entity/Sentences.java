package com.ust.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sentences")
public class Sentences {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Sentences_id",nullable = false)
	private int sentencesId;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lesson_id",nullable = false)
	private Lesson lesson;
	
	@Column(name="Sentences",nullable=false)
	private String sentences;
	
	@Column(name="Sentences_IsActive",nullable=false)
	private int sentencesIsActive;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Sentences_MediaID",nullable = false)
	private Media media;
	
	
	
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public int getSentencesIsActive() {
		return sentencesIsActive;
	}
	public void setSentencesIsActive(int sentencesIsActive) {
		this.sentencesIsActive = sentencesIsActive;
	}
	public int getSentencesId() {
		return sentencesId;
	}
	public void setSentencesId(int sentencesId) {
		this.sentencesId = sentencesId;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public String getSentences() {
		return sentences;
	}
	public void setSentences(String sentences) {
		this.sentences = sentences;
	}
	
	

}
