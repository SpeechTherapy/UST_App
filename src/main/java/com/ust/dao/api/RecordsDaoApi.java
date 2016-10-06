package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Records;

public interface RecordsDaoApi {
	public abstract void persist(Records records); //save

    public abstract void attachDirty(Records records); //save and update

    public abstract void attachClean(Records records); //clean 

    public abstract void delete(Records records); //used for record del

    public abstract Records merge(Records records); //used for updation

    public abstract Records findById(int id); //search
    

    public abstract List<Records> findByExampleWithLike(Records records);

    public abstract List<Records> findAll();

}
