package com.ust.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.entity.WordsMedia;
import com.ust.dao.api.WordsMediaDaoApi;
import com.ust.service.api.WordsMediaServiceApi;

@Service
public class WordsMediaServiceImpl implements WordsMediaServiceApi
{
	@Autowired
	private WordsMediaDaoApi wordsmediaDaoApi;

	@Override
	public void save(WordsMedia wordsmedia) {
		wordsmediaDaoApi.persist(wordsmedia);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(WordsMedia wordsmedia) {
		wordsmediaDaoApi.attachDirty(wordsmedia);
		
	}

	@Override
	public void update(WordsMedia wordsmedia) {
		wordsmediaDaoApi.merge(wordsmedia);		
	}

	@Override
	public void delete(WordsMedia wordsmedia) {
		wordsmediaDaoApi.delete(wordsmedia);		
	}

	@Override
	public WordsMedia findById(int id) {
		return wordsmediaDaoApi.findById(id);

	}

	@Override
	public List<WordsMedia> findByWordsmedia(WordsMedia wordsmedia) {
		return wordsmediaDaoApi.findByExampleWithLike(wordsmedia);

	}

	@Override
	public List<WordsMedia> findAll() {
		return wordsmediaDaoApi.findAll();
	}

	
}