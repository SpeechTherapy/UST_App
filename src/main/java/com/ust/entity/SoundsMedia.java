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
@Table (name="sound_media")
public class SoundsMedia
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Sound_Media_id",nullable = false)
	private int soundmediaId;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Sounds.class,fetch = FetchType.LAZY)
	@JoinColumn(name="Sounds_id",nullable = false)
	private Sounds soundsId;

	@JsonIgnore
	@ManyToOne(targetEntity = Media.class,fetch = FetchType.LAZY)
	@JoinColumn(name="Media_id",nullable = false)
	private Media mediaId;

	public int getSoundmediaId() {
		return soundmediaId;
	}

	public void setSoundmediaId(int soundmediaId) {
		this.soundmediaId = soundmediaId;
	}

	public Sounds getSoundsId() {
		return soundsId;
	}

	public void setSoundsId(Sounds soundsId) {
		this.soundsId = soundsId;
	}

	public Media getMediaId() {
		return mediaId;
	}

	public void setMediaId(Media mediaId) {
		this.mediaId = mediaId;
	}

	
	

	
}