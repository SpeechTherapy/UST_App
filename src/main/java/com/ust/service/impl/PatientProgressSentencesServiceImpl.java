package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.PatientProgressSentencesDaoApi;
import com.ust.entity.PatientProgressSentences;
import com.ust.service.api.PatientProgressSentencesServiceApi;

@Service

public class PatientProgressSentencesServiceImpl implements PatientProgressSentencesServiceApi{
	
	
	@Autowired
	private PatientProgressSentencesDaoApi patientprogresssentencesDaoApi;

	@Override
	public void save(PatientProgressSentences patientprogresssentences) {
		patientprogresssentencesDaoApi.persist(patientprogresssentences);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(PatientProgressSentences patientprogresssentences) {
		patientprogresssentencesDaoApi.attachDirty(patientprogresssentences);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PatientProgressSentences patientprogresssentences) {
		patientprogresssentencesDaoApi.merge(patientprogresssentences);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PatientProgressSentences patientprogresssentences) {
		// TODO Auto-generated method stub
		patientprogresssentencesDaoApi.delete(patientprogresssentences);
	}

	@Override
	public PatientProgressSentences findById(int id) {
		return patientprogresssentencesDaoApi.findById(id);
	}

	@Override
	public List<PatientProgressSentences> findByPatientProgressSentences(PatientProgressSentences patientprogresssentences) {
		return patientprogresssentencesDaoApi.findByExampleWithLike(patientprogresssentences);
	}

	@Override
	public List<PatientProgressSentences> findAll() {
		return patientprogresssentencesDaoApi.findAll();
	}

}

