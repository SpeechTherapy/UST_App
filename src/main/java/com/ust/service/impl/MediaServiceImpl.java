package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.MediaDaoApi;
import com.ust.entity.Media;
import com.ust.service.api.MediaServiceApi;

@Service
public class MediaServiceImpl implements MediaServiceApi
{
	@Autowired
	private MediaDaoApi mediaDaoApi;

	@Override
	public void save(Media media) 
	{
		
		// TODO Auto-generated method stub
		mediaDaoApi.persist(media);
	}

	@Override
	public void saveOrUpdate(Media media) {
		// TODO Auto-generated method stub
		mediaDaoApi.attachDirty(media);
	}

	@Override
	public void update(Media media) {
		// TODO Auto-generated method stub
		mediaDaoApi.merge(media);
	}

	@Override
	public void delete(Media media) {
		// TODO Auto-generated method stub
		mediaDaoApi.delete(media);

	}

	@Override
	public Media findById(int id) 
	{
		// TODO Auto-generated method stub
		return mediaDaoApi.findById(id);	
	}

	@Override
	public List<Media> findByMedia(Media media) 
	{
		// TODO Auto-generated method stub
		return mediaDaoApi.findByExampleWithLike(media);
	}

	@Override
	public List<Media> findAll() {
		// TODO Auto-generated method stub
		return mediaDaoApi.findAll();
	}
	
}