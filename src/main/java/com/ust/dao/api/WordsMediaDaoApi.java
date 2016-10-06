package com.ust.dao.api;

import java.util.List;

import com.ust.entity.WordsMedia;

public interface WordsMediaDaoApi
{
	public abstract void persist(WordsMedia wordsmedia); //save

    public abstract void attachDirty(WordsMedia wordsmedia); //save and update

    public abstract void attachClean(WordsMedia wordsmedia); //clean 

    public abstract void delete(WordsMedia wordsmedia); //used for record del

    public abstract WordsMedia findById(int id); //search

    public abstract List<WordsMedia> findAll();

	public abstract List<WordsMedia> findByExampleWithLike(WordsMedia wordsmedia);

	public abstract WordsMedia merge(WordsMedia wordsmedia);

}