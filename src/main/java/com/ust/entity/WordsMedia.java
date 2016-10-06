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
@Table(name="words_media")
public class WordsMedia
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Words_media_id",nullable = false)
	private int wordsmediaId; //Wordsmedia = City, wordsmedia = city
	
	private int media;

	@JsonIgnore
	@ManyToOne(targetEntity = Words.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "Words_id",nullable = false)
	private int Words_id;
	
	
	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public int getWordsmediaId() 
	{
		return wordsmediaId;
	}

	public void setWordsmediaId(int wordsmediaId) 
	{
		this.wordsmediaId = wordsmediaId;
	}

	
	public int getWords_id() 
	{
		return Words_id;
	}

	public void setWords_id(int words_id) 
	{
		Words_id = words_id;
	}

}