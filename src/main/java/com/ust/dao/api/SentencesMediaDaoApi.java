package com.ust.dao.api;

import java.util.List;

import com.ust.entity.SentencesMedia;

public interface SentencesMediaDaoApi
{
	public abstract void persist(SentencesMedia sentencesmedia); //save

    public abstract void attachDirty(SentencesMedia sentencesmedia); //save and update

    public abstract void attachClean(SentencesMedia sentencesmedia); //clean 

    public abstract void delete(SentencesMedia sentencesmedia); //used for record del

    public abstract SentencesMedia merge(SentencesMedia sentencesmedia); //used for updation

    public abstract SentencesMedia findById(int id); //search
    

    public abstract List<SentencesMedia> findByExampleWithLike(SentencesMedia sentencesmedia);

    public abstract List<SentencesMedia> findAll();
}