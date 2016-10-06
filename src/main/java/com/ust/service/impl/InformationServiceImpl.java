package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.InformationDaoApi;
import com.ust.entity.Information;
import com.ust.service.api.InformationServiceApi;

@Service
public class InformationServiceImpl implements InformationServiceApi
{
	@Autowired
	private InformationDaoApi informationDaoApi;
	
	@Override
	public void save(Information information) 
	{
		// TODO Auto-generated method stub
		informationDaoApi.persist(information);
	}

	@Override
	public void saveOrUpdate(Information information) {
		// TODO Auto-generated method stub
		informationDaoApi.attachDirty(information);
	}

	@Override
	public void update(Information information) {
		// TODO Auto-generated method stub
		informationDaoApi.merge(information);
	}

	@Override
	public void delete(Information information) 
	{
		// TODO Auto-generated method stub
		informationDaoApi.delete(information);
	}

	@Override
	public Information findById(int id) {
		// TODO Auto-generated method stub
		return informationDaoApi.findById(id);
	}

	@Override
	public List<Information> findByInformation(Information information) {
		// TODO Auto-generated method stub
		return informationDaoApi.findByExampleWithLike(information);
	}

	@Override
	public List<Information> findAll() {
		// TODO Auto-generated method stub
		return informationDaoApi.findAll();
	}
	
}