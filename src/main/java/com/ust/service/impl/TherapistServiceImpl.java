package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.TherapistDaoApi;
import com.ust.entity.Therapist;
import com.ust.service.api.TherapistServiceApi;

@Service
public class TherapistServiceImpl implements TherapistServiceApi{
	
	@Autowired
	private TherapistDaoApi therapistDaoApi;

	@Override
	public void save(Therapist therapist) {

		therapistDaoApi.persist(therapist);
	}

	@Override
	public void saveOrUpdate(Therapist therapist) {

		therapistDaoApi.attachDirty(therapist);
		
	}

	@Override
	public void update(Therapist therapist) {

		therapistDaoApi.merge(therapist);
	}

	@Override
	public void delete(Therapist therapist) {

		therapistDaoApi.delete(therapist);
	}

	@Override
	public Therapist findById(int id) {

		return therapistDaoApi.findById(id);
	}

	@Override
	public List<Therapist> findByTherapist(Therapist therapist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Therapist> findAll() {
		// TODO Auto-generated method stub
		return therapistDaoApi.findAll();
	}
	
	@Override
	public List<Therapist> findTherapist() {
		// TODO Auto-generated method stub
		return therapistDaoApi.findTherapist();
	}
	
	
	
	@Override
	public Therapist Report(int id){
		return therapistDaoApi.Report(id);
	}

	

}
