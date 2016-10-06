package com.ust.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.PatientsProgressWordDaoApi;
import com.ust.entity.PatientsProgressWord;

import com.ust.service.api.PatientsProgressWordServiceApi;
@Service
public class PatientsProgressWordServiceImpl implements PatientsProgressWordServiceApi
{
	@Autowired
	private PatientsProgressWordDaoApi patientsprogresswordDaoApi;

	@Override
	public void save(PatientsProgressWord patientsprogressword) 
	{
		
		// TODO Auto-generated method stub
		patientsprogresswordDaoApi.persist(patientsprogressword);
	}

	@Override
	public void saveOrUpdate(PatientsProgressWord patientsprogressword) {
		// TODO Auto-generated method stub
		patientsprogresswordDaoApi.attachDirty(patientsprogressword);
	}

	@Override
	public void update(PatientsProgressWord patientsprogressword) {
		// TODO Auto-generated method stub
		patientsprogresswordDaoApi.merge(patientsprogressword);
	}

	@Override
	public void delete(PatientsProgressWord patientsprogressword) {
		// TODO Auto-generated method stub
		patientsprogresswordDaoApi.delete(patientsprogressword);
	}

	@Override
	public PatientsProgressWord findById(int id) {
		// TODO Auto-generated method stub
		return patientsprogresswordDaoApi.findById(id);
	}

	@Override
	public List<PatientsProgressWord> findByPatientsProgressWord(PatientsProgressWord patientsprogressword) {
		// TODO Auto-generated method stub
		return patientsprogresswordDaoApi.findByExampleWithLike(patientsprogressword);
	}

	@Override
	public List<PatientsProgressWord> findAll() {
		// TODO Auto-generated method stub
		return patientsprogresswordDaoApi.findAll();
	}
	
}

