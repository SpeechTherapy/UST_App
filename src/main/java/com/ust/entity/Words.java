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
@Table(name="words")
public class Words 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Words_id",nullable = false)
	private int wordsId;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Lesson_id",nullable = false)
	private Lesson lesson;
	
	@Column(name="Words",nullable = false)
	private String words;
	
	@Column(name="Word_IsActive",nullable = false)
	private int wordIsActive;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Words_MediaId",nullable = false)
	private Media media;
	
	
	
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public int getWordIsActive() {
		return wordIsActive;
	}
	public void setWordIsActive(int wordIsActive) {
		this.wordIsActive = wordIsActive;
	}
	public int getWordsId() {
		return wordsId;
	}
	public void setWordsId(int wordsId) {
		this.wordsId = wordsId;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	
}