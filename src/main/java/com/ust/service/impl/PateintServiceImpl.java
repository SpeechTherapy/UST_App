package com.ust.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.PatientDaoApi;
import com.ust.entity.Patient;
import com.ust.service.api.PatientserviceApi;
@Service
public class PateintServiceImpl implements PatientserviceApi{
	@Autowired
	private PatientDaoApi patientDaoApi;

	@Override
	public void save(Patient patient) {
		// TODO Auto-generated method stub
		patientDaoApi.persist(patient);
	}

	@Override
	public int saveOrUpdate(Patient patient) {
		// TODO Auto-generated method stub
		return  patientDaoApi.attachDirty(patient);

	}

	@Override
	public void update(Patient patient) {
		// TODO Auto-generated method stub
		patientDaoApi.merge(patient);

		
	}

	@Override
	public void delete(Patient patient) {
		patientDaoApi.delete(patient);
		
	}

	@Override
	public Patient findById(int id) {
		return patientDaoApi.findById(id);

	}
	
	

	@Override
	public List<Patient> findByPatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findAll() {
		return patientDaoApi.findAll();

	}

}
