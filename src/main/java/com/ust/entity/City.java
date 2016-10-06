package com.ust.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="city")
public class City {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="City_id",nullable = false)
	private int cityId;
	
	@Column(name="City_name",nullable = false)
	private String cityName;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="city")
	Set<Hospital> hospital= new HashSet<Hospital>();
	
	
	
	public Set<Hospital> getHospital() {
		return hospital;
	}

	public void setHospital(Set<Hospital> hospital) {
		this.hospital = hospital;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
