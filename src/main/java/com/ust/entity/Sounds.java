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
@Table(name="sounds")
public class Sounds {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Sounds_id",nullable = false)
	private int soundsId;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Lesson_id",nullable = false)
	private Lesson lesson;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Sound_MediaId",nullable = false)
	private Media media;
	
	@Column(name="Sound",nullable = false)
	private String sound;
	
	@Column(name="Sound_isActive",nullable = false)
	private int soundIsActive;
	
	
	
	
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public int getSoundIsActive() {
		return soundIsActive;
	}
	public void setSoundIsActive(int soundIsActive) {
		this.soundIsActive = soundIsActive;
	}
	public int getSoundsId() {
		return soundsId;
	}
	public void setSoundsId(int soundsId) {
		this.soundsId = soundsId;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	
	

}
