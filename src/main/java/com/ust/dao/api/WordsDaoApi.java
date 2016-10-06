package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Words;

public interface WordsDaoApi 
{
	public abstract void persist(Words words);

    public abstract void attachDirty(Words words);

    public abstract void attachClean(Words words);

    public abstract void delete(Words words);

    public abstract Words merge(Words words);

    public abstract Words findById(int id);

    public abstract List<Words> findByExampleWithLike(Words words);

    public abstract List<Words> findAll();

}
