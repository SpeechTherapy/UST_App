package com.ust.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lesson")
public class Lesson {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Lesson_id",nullable = false)
	private int lessonId;
	
	@Column(name="Lesson",nullable=false)
	private String lesson;
	
	@Column(name="LessonPic",nullable=false)
	private String lessonPic;
	
	@Column(name="Video_Refrence",nullable=false)
	private String videoReference;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="lesson")
	Set<AssignedChapterTherapist> assignedChapterTherapist= new HashSet<AssignedChapterTherapist>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="lesson")
	Set<Sounds> sounds= new HashSet<Sounds>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="lesson")
	Set<Words> words= new HashSet<Words>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="lesson")
	Set<Sentences> sentences= new HashSet<Sentences>();
	
	

	public Set<Words> getWords() {
		return words;
	}

	public void setWords(Set<Words> words) {
		this.words = words;
	}

	public Set<Sentences> getSentences() {
		return sentences;
	}

	public void setSentences(Set<Sentences> sentences) {
		this.sentences = sentences;
	}

	public Set<Sounds> getSounds() {
		return sounds;
	}

	public void setSounds(Set<Sounds> sounds) {
		this.sounds = sounds;
	}

	public Set<AssignedChapterTherapist> getAssignedChapterTherapist() {
		return assignedChapterTherapist;
	}

	public void setAssignedChapterTherapist(Set<AssignedChapterTherapist> assignedChapterTherapist) {
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

	public String getLessonPic() {
		return lessonPic;
	}

	public void setLessonPic(String lessonPic) {
		this.lessonPic = lessonPic;
	}
	
	
	

}
