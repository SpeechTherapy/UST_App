package com.ust.service.api;

import java.util.List;

import com.ust.entity.WordsMedia;

public interface WordsMediaServiceApi
{
	public abstract void save(WordsMedia wordsmedia);

    public void saveOrUpdate(WordsMedia wordsmedia);

    public abstract void update(WordsMedia wordsmedia);

    public abstract void delete(WordsMedia wordsmedia);

    public abstract WordsMedia findById(int id);

    public abstract List<WordsMedia> findByWordsmedia(WordsMedia wordsmedia);

    public abstract List<WordsMedia> findAll();

}