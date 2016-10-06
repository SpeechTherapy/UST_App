package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.PatientProgressSoundDaoApi;
import com.ust.entity.PatientProgressSound;
import com.ust.service.api.PatientProgressSoundServiceApi;

@Service
public class PatientProgressSoundServiceImpl implements PatientProgressSoundServiceApi {

	
	@Autowired
	private PatientProgressSoundDaoApi patientprogresssoundDaoApi;

	@Override
	public void save(PatientProgressSound patientprogresssound) {
		patientprogresssoundDaoApi.persist(patientprogresssound);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(PatientProgressSound patientprogresssound) {
		patientprogresssoundDaoApi.attachDirty(patientprogresssound);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PatientProgressSound patientprogresssound) {
		patientprogresssoundDaoApi.merge(patientprogresssound);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PatientProgressSound patientprogresssound) {
		// TODO Auto-generated method stub
		patientprogresssoundDaoApi.delete(patientprogresssound);
	}

	@Override
	public PatientProgressSound findById(int id) {
		return patientprogresssoundDaoApi.findById(id);
	}


	@Override
	public List<PatientProgressSound> findAll() {
		return patientprogresssoundDaoApi.findAll();
	}

	@Override
	public List<PatientProgressSound> findByPateintProgressSound(PatientProgressSound patientprogresssound) {
		// TODO Auto-generated method stub
		return patientprogresssoundDaoApi.findByExampleWithLike(patientprogresssound);
	}

}
