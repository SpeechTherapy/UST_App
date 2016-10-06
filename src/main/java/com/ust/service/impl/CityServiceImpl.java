package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.CityDaoApi;

import com.ust.entity.City;
import com.ust.service.api.CityServiceApi;

@Service
public class CityServiceImpl implements CityServiceApi {
	
	@Autowired
	private CityDaoApi cityDaoApi;

	@Override
	public int save(City city) {
		// TODO Auto-generated method stub
		return cityDaoApi.persist(city);
	}

	@Override
	public void saveOrUpdate(City city) {
		// TODO Auto-generated method stub
		cityDaoApi.attachDirty(city);	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		cityDaoApi.merge(city);


	}

	@Override
	public void delete(City city) {
		// TODO Auto-generated method stub
		cityDaoApi.delete(city);

	}

	@Override
	public City findById(int id) {
		// TODO Auto-generated method stub
		return cityDaoApi.findById(id);	}

	

	@Override
	public List<City> findByCity(City city) {
		// TODO Auto-generated method stub
		return cityDaoApi.findByExampleWithLike(city);
	}

	@Override
	public List<City> findAll() {
		// TODO Auto-generated method stub
		return cityDaoApi.findAll();
	}

}
