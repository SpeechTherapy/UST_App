package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.SentencesDaoApi;
import com.ust.entity.Sentences;
import com.ust.service.api.SentencesServiceApi;


@Service
public class SentencesServiceImpl implements SentencesServiceApi{
	
	@Autowired
	private SentencesDaoApi sentencesDaoApi;

	@Override
	public void save(Sentences sentences) {
		sentencesDaoApi.persist(sentences);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Sentences sentences) {
		sentencesDaoApi.attachDirty(sentences);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Sentences sentences) {
		sentencesDaoApi.merge(sentences);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sentences sentences) {
		// TODO Auto-generated method stub
		sentencesDaoApi.delete(sentences);
	}

	@Override
	public Sentences findById(int id) {
		return sentencesDaoApi.findById(id);
	}

	@Override
	public List<Sentences> findBySentences(Sentences sentences) {
		return sentencesDaoApi.findByExampleWithLike(sentences);
	}

	@Override
	public List<Sentences> findAll() {
		return sentencesDaoApi.findAll();
	}


}
