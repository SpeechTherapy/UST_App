package com.ust.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="information")
public class Information
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="information_id",nullable = false)
	private int informationId;
	
	@Column(name="Text",nullable = false)
	private String text;
	
	@Column(name="ages",nullable = false)
	private String ages;

	public int getInformationId() {
		return informationId;
	}

	public void setInformationId(int informationId) {
		this.informationId = informationId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAges() {
		return ages;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}
	
	
}