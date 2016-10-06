package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.HospitalDaoApi;
import com.ust.entity.Hospital;
import com.ust.service.api.HospitalServiceApi;

@Service
public class HospitalServiceImpl implements HospitalServiceApi{
	
	@Autowired
	private HospitalDaoApi hospitalDaoApi;

	@Override
	public int save(Hospital hospital) {
		
		// TODO Auto-generated method stub
		return hospitalDaoApi.persist(hospital) ;
		
	}

	@Override
	public void saveOrUpdate(Hospital hospital) {
		hospitalDaoApi.attachDirty(hospital);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Hospital hospital) {
		hospitalDaoApi.merge(hospital);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hospital hospital) {
		// TODO Auto-generated method stub
		hospitalDaoApi.delete(hospital);
	}

	@Override
	public Hospital findById(int id) {
		return hospitalDaoApi.findById(id);
	}

	@Override
	public List<Hospital> findByHospital(Hospital hospital) {
		return hospitalDaoApi.findByExampleWithLike(hospital);
	}

	@Override
	public List<Hospital> findAll() {
		return hospitalDaoApi.findAll();
	}

}
