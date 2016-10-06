package com.ust.service.api;

import java.util.List;

import com.ust.entity.SentencesMedia;


public interface SentencesMediaServiceApi
{
	 public abstract void save(SentencesMedia sentencesmedia);

	    public void saveOrUpdate(SentencesMedia sentencesmedia);

	    public abstract void update(SentencesMedia sentencesmedia);

	    public abstract void delete(SentencesMedia sentencesmedia);

	    public abstract SentencesMedia findById(int id);

	    public abstract List<SentencesMedia> findBySentencesMedia(SentencesMedia sentencesmedia);

	    public abstract List<SentencesMedia> findAll();

}