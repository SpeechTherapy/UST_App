package com.ust.service.api;

import java.util.List;

import com.ust.entity.Sentences;

public interface SentencesServiceApi {
	
	public abstract void save(Sentences sentences);

    public void saveOrUpdate(Sentences sentences);

    public abstract void update(Sentences sentences);

    public abstract void delete(Sentences sentences);

    public abstract Sentences findById(int id);

    public abstract List<Sentences> findBySentences(Sentences sentences);

    public abstract List<Sentences> findAll();

}
