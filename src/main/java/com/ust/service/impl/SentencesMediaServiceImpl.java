package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.SentencesMediaDaoApi;
import com.ust.entity.SentencesMedia;

import com.ust.service.api.SentencesMediaServiceApi;

@Service
public class SentencesMediaServiceImpl implements SentencesMediaServiceApi
{

	@Autowired
	private SentencesMediaDaoApi sentencesmediaDaoApi;
	@Override
	public void save(SentencesMedia sentencesmedia) 
	{
		// TODO Auto-generated method stub
		sentencesmediaDaoApi.persist(sentencesmedia);
	}

	@Override
	public void saveOrUpdate(SentencesMedia sentencesmedia) 
	{
		// TODO Auto-generated method stub
		sentencesmediaDaoApi.attachDirty(sentencesmedia);
	}

	@Override
	public void update(SentencesMedia sentencesmedia) 
	{
		// TODO Auto-generated method stub
		sentencesmediaDaoApi.merge(sentencesmedia);
	}

	@Override
	public void delete(SentencesMedia sentencesmedia) 
	{
		// TODO Auto-generated method stub
		sentencesmediaDaoApi.delete(sentencesmedia);
	}

	@Override
	public SentencesMedia findById(int id) 
	{
		// TODO Auto-generated method stub
		return sentencesmediaDaoApi.findById(id);
	}

	@Override
	public List<SentencesMedia> findBySentencesMedia(SentencesMedia sentencesmedia) {
		// TODO Auto-generated method stub
		return sentencesmediaDaoApi.findByExampleWithLike(sentencesmedia);
	}

	@Override
	public List<SentencesMedia> findAll() {
		// TODO Auto-generated method stub
		return sentencesmediaDaoApi.findAll();
	}
	
}