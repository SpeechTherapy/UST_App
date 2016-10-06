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
@Table(name="sentences_media")
public class SentencesMedia
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Sentences_Media_id",nullable = false)
	private int sentencesmediaId;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Sentences.class,fetch = FetchType.LAZY)
	@JoinColumn(name="Sentences",nullable = false)
	private int sentences;

	@JsonIgnore
	@ManyToOne(targetEntity = Media.class, fetch = FetchType.LAZY)
	@JoinColumn(name="Media",nullable = false)
	private int media;

	public int getSentencesmediaId() {
		return sentencesmediaId;
	}

	public void setSentencesmediaId(int sentencesmediaId) {
		this.sentencesmediaId = sentencesmediaId;
	}

	public int getSentences() {
		return sentences;
	}

	public void setSentences(int sentences) {
		this.sentences = sentences;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}
	
	
}