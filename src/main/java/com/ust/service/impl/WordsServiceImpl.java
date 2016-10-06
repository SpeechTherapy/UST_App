package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.WordsDaoApi;
import com.ust.entity.Words;
import com.ust.service.api.WordsServiceApi;

@Service
public class WordsServiceImpl implements WordsServiceApi
{

	@Autowired
	private WordsDaoApi wordsDaoApi;	
	
	@Override
	public void save(Words words) 
	{
		// TODO Auto-generated method stub
		wordsDaoApi.persist(words);
	}

	@Override
	public void saveOrUpdate(Words words) 
	{
		wordsDaoApi.attachDirty(words);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Words words) 
	{
		wordsDaoApi.merge(words);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Words words) 
	{
		wordsDaoApi.delete(words);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Words findById(int id) 
	{
		// TODO Auto-generated method stub
		return wordsDaoApi.findById(id);
	}

	@Override
	public List<Words> findByWords(Words words) 
	{
		// TODO Auto-generated method stub
		return wordsDaoApi.findByExampleWithLike(words);
	}

	@Override
	public List<Words> findAll() 
	{
		// TODO Auto-generated method stub
		return wordsDaoApi.findAll();
	}
	
}