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
@Table (name="media")

public class Media
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Media_id",nullable = false)
	private int mediaId;
	
	@Column(name="Media_image",nullable = false)
	private String mediaImage;
	
	@Column(name="Media_audio",nullable = false)
	private String mediaAudio;

	
	
	public Set<Words> getWord() {
		return word;
	}

	public void setWord(Set<Words> word) {
		this.word = word;
	}

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="media")
	Set<Sounds> sound=new HashSet<Sounds>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="media")
	Set<Words> word=new HashSet<Words>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="media")
	Set<Sentences> sentences=new HashSet<Sentences>();
	
	
	
	
	
	public Set<Sentences> getSentences() {
		return sentences;
	}

	public void setSentences(Set<Sentences> sentences) {
		this.sentences = sentences;
	}

	public Set<Sounds> getSound() {
		return sound;
	}

	public void setSound(Set<Sounds> sound) {
		this.sound = sound;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaImage() {
		return mediaImage;
	}

	public void setMediaImage(String mediaImage) {
		this.mediaImage = mediaImage;
	}

	public String getMediaAudio() {
		return mediaAudio;
	}

	public void setMediaAudio(String mediaAudio) {
		this.mediaAudio = mediaAudio;
	}

	
}