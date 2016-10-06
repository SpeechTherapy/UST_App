package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Sentences;

public interface SentencesDaoApi {
	public abstract void persist(Sentences sentences); //save

    public abstract void attachDirty(Sentences sentences); //save and update

    public abstract void attachClean(Sentences sentences); //clean 

    public abstract void delete(Sentences sentences); //used for record del

    public abstract Sentences merge(Sentences sentences); //used for updation

    public abstract Sentences findById(int id); //search
    

    public abstract List<Sentences> findByExampleWithLike(Sentences sentences);

    public abstract List<Sentences> findAll();

}
