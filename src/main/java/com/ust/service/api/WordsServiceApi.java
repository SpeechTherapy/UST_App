package com.ust.service.api;

import java.util.List;

import com.ust.entity.Words;

public interface WordsServiceApi
{
	 public abstract void save(Words words);

	    public void saveOrUpdate(Words words);

	    public abstract void update(Words words);

	    public abstract void delete(Words words);

	    public abstract Words findById(int id);

	    public abstract List<Words> findByWords(Words words);

	    public abstract List<Words> findAll();

}
