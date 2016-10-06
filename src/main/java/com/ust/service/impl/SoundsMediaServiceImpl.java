package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.SoundsMediaDaoApi;
import com.ust.entity.SoundsMedia;
import com.ust.service.api.SoundsMediaServiceApi;

@Service
public class SoundsMediaServiceImpl implements SoundsMediaServiceApi
{

	@Autowired
	private SoundsMediaDaoApi soundsmediaDaoApi;

	
	@Override
	public void save(SoundsMedia soundsmedia) 
	{
		
		// TODO Auto-generated method stub
		soundsmediaDaoApi.attachDirty(soundsmedia);
	}

	@Override
	public void saveOrUpdate(SoundsMedia soundsmedia) {
		// TODO Auto-generated method stub
		soundsmediaDaoApi.merge(soundsmedia);
	}

	@Override
	public void update(SoundsMedia soundsmedia) 
	{
		// TODO Auto-generated method stub
		soundsmediaDaoApi.merge(soundsmedia);

	}

	@Override
	public void delete(SoundsMedia soundsmedia) 
	{
		// TODO Auto-generated method stub
	 	soundsmediaDaoApi.delete(soundsmedia);
	}

	@Override
	public SoundsMedia findById(int id) 
	{
		// TODO Auto-generated method stub
		return soundsmediaDaoApi.findById(id);
	}

	@Override
	public List<SoundsMedia> findBySoundsMedia(SoundsMedia soundsmedia) 
	{
		// TODO Auto-generated method stub
		return soundsmediaDaoApi.findByExampleWithLike(soundsmedia);
	}

	@Override
	public List<SoundsMedia> findAll() {
		// TODO Auto-generated method stub
		return soundsmediaDaoApi.findAll();
	}
	
}