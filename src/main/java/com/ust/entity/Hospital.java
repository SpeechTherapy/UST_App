package com.ust.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hospital")
public class Hospital {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Hospital_id",nullable = false)
	private int hospitalId;
	
	@Column(name="Hospital_name",nullable = false)
	private String hospitalName;
	
	@Column(name="Hospital_address",nullable = false)
	private String hospitalAddress;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "City_id",nullable = false)
	private City city;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="hospital")
	Set<Therapist> therapist= new HashSet<Therapist>();
	
	
	

	public Set<Therapist> getTherapist() {
		return therapist;
	}

	public void setTherapist(Set<Therapist> therapist) {
		this.therapist = therapist;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
